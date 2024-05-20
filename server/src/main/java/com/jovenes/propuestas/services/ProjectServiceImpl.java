package com.jovenes.propuestas.services;

import com.jovenes.propuestas.entities.Image;
import com.jovenes.propuestas.entities.Project;
import com.jovenes.propuestas.enums.RelatedType;
import com.jovenes.propuestas.repositories.ProjectRepository;
import com.jovenes.propuestas.services.interfaces.ImageService;
import com.jovenes.propuestas.services.interfaces.ProjectService;
import com.jovenes.propuestas.utils.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ImageService imageService;
    public Project findById(int id) throws NoSuchElementException{
        return this.projectRepository.findById(id).get();
    }

    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    public Image uploadImage(int projectId, MultipartFile file) throws IOException, NoSuchElementException {
        Project project = this.findById(projectId);
        String path = Storage.transferImage(project, file);
        return this.imageService.createImage(RelatedType.PROYECT, project, file, path);
    }
}
