package com.jovenes.propuestas.services.interfaces;

import com.jovenes.propuestas.entities.Image;
import com.jovenes.propuestas.entities.Project;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public interface ProjectService {

    Project findById(int id);

    List<Project> getAllProjects();

    Image uploadImage(int proyectId, MultipartFile file) throws IOException, NoSuchElementException;
}
