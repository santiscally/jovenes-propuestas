package com.jovenes.propuestas.controllers;

import com.jovenes.propuestas.dtos.ProjectDTO;
import com.jovenes.propuestas.entities.Image;
import com.jovenes.propuestas.entities.Project;
import com.jovenes.propuestas.requests.ImageRequest;
import com.jovenes.propuestas.services.interfaces.ProjectService;
import com.jovenes.propuestas.utils.DTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/proyect")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    ProjectService projectService;
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Integer id,
                                                     @RequestParam(value = "fields", required = true) List<String> fields) {
        try {
            Project project = this.projectService.findById(id);
            if (project != null) {
                ProjectDTO dto = DTOWrapper.getDto(project, fields, ProjectDTO.class);
                return ResponseEntity.ok(dto); // 200 OK
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (Exception e) {
            // Log the exception
            logger.error("Error al querer conseguir proyecto con el siguiente id: " + id, e);
            // Return 500 Internal Server Error along with the error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>> getAllProjects(@RequestParam(value = "fields", required = true) List<String> fields) {
        try {
            List<Project> projects = this.projectService.getAllProjects();
            if (projects.isEmpty()) {
                List<ProjectDTO> dtos = DTOWrapper.getDtos(projects, fields, ProjectDTO.class);
                return ResponseEntity.ok(dtos); // 200 OK
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (Exception e) {
            String errorMessage = "Error al querer conseguir proyecto con el siguiente";
            logger.error(errorMessage, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadImage(@ModelAttribute ImageRequest request) {
        try {
            int projectId = Integer.parseInt(request.getId());
            Image image = this.projectService.uploadImage(projectId, request.getFile());
            return ResponseEntity.ok("Imagen cargada correctamente: " + image.getName());
        } catch (Exception e) {
            String errorMessage = "Hubo un error al querer subir la imagen";
            logger.error(errorMessage, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
