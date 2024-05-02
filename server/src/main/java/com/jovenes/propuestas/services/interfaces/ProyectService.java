package com.jovenes.propuestas.services.interfaces;

import com.jovenes.propuestas.entities.Proyect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProyectService {

    Proyect findById(int id);

    List<Proyect> getAllProyects();
}
