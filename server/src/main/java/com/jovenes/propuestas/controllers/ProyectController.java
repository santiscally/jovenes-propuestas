package com.jovenes.propuestas.controllers;

import com.jovenes.propuestas.dtos.ProyectDTO;
import com.jovenes.propuestas.entities.Proyect;
import com.jovenes.propuestas.services.interfaces.ProyectService;
import com.jovenes.propuestas.utils.DTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/proyect")
public class ProyectController {

    private static final String UPLOAD_DIRECTORY = "C:\\Users\\Santi\\Pictures";
    private static final Logger logger = LoggerFactory.getLogger(ProyectController.class);
    @Autowired
    ProyectService proyectService;
    @GetMapping("/{id}")
    public ResponseEntity<ProyectDTO> getProyectById(@PathVariable Integer id, @RequestParam(value = "fields", required = true) List<String> fields) {
        try {
            Proyect proyect = this.proyectService.findById(id);
            if (proyect != null) {
                ProyectDTO dto = DTOWrapper.getDto(proyect, fields, ProyectDTO.class);
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
    public ResponseEntity<List<ProyectDTO>> getAllProyects(@RequestParam(value = "fields", required = true) List<String> fields) {
        try {
            List<Proyect> proyects = this.proyectService.getAllProyects();
            if (!proyects.isEmpty()) {
                List<ProyectDTO> dtos = DTOWrapper.getDtos(proyects, fields, ProyectDTO.class);
                return ResponseEntity.ok(dtos); // 200 OK
            } else {
                return ResponseEntity.notFound().build(); // 404 Not Found
            }
        } catch (Exception e) {
            // Log the exception
            logger.error("Error al querer conseguir proyecto con el siguiente", e);
            // Return 500 Internal Server Error along with the error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        try {
            // Crea el directorio de carga si no existe
            File uploadDir = new File(UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Guarda la imagen en el directorio de carga
            String fileName = file.getOriginalFilename();
            File destFile = new File(UPLOAD_DIRECTORY + "/" + fileName);
            file.transferTo(destFile);

            return ResponseEntity.ok("Imagen cargada correctamente: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
