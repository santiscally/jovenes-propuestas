package com.jovenes.propuestas.controllers;

import com.jovenes.propuestas.entities.Proyect;
import com.jovenes.propuestas.services.interfaces.ProyectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyects")
public class ProyectController {

    private static final Logger logger = LoggerFactory.getLogger(ProyectController.class);
    @Autowired
    ProyectService proyectService;
    @GetMapping("/{id}")
    public ResponseEntity<Proyect> getProyectById(@PathVariable Integer id) {
        try {
            Proyect proyect = this.proyectService.findById(id);
            if (proyect != null) {
                return ResponseEntity.ok(proyect); // 200 OK
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
}
