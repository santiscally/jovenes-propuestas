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

import java.util.List;

@RestController
@RequestMapping("/proyect")
public class ProyectController {

    private static final Logger logger = LoggerFactory.getLogger(ProyectController.class);
    @Autowired
    ProyectService proyectService;
    @GetMapping("/{id}")
    public ResponseEntity<ProyectDTO> getProyectById(@PathVariable Integer id, @RequestParam(value = "fields", required = false) List<String> fields) {
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

    @GetMapping
    public Page<Proyect> getAllProyects(Pageable pageable) {
        return this.proyectService.getAllProyects(pageable);
    }
}
