package com.jovenes.propuestas.services;

import com.jovenes.propuestas.entities.Proyect;
import com.jovenes.propuestas.repositories.ProyectRepository;
import com.jovenes.propuestas.services.interfaces.ProyectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectServiceImpl implements ProyectService {
    @Autowired
    ProyectRepository proyectRepository;
    @Override
    public Proyect findById(int id) {
        return this.proyectRepository.findById(id).isPresent() ? this.proyectRepository.findById(id).get(): null;
    }
}
