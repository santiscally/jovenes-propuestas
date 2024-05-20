package com.jovenes.propuestas.services;

import com.jovenes.propuestas.base.BaseEntity;
import com.jovenes.propuestas.entities.Image;
import com.jovenes.propuestas.enums.RelatedType;
import com.jovenes.propuestas.repositories.ImageRepository;
import com.jovenes.propuestas.services.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    @Override
    public Image saveImage(Image image) {
        return this.imageRepository.save(image);
    }

    @Override
    public <E extends BaseEntity> Image createImage(RelatedType relatedType, E entity, MultipartFile file, String path) {

        Image image = Image.builder()
                .name(file.getOriginalFilename())
                .path(path)
                .contentType(file.getContentType())
                .size(file.getSize())
                .relatedId(entity.getId())
                .relatedType(relatedType)
                .createdByUser(entity.getCreatedByUser())
                .createdTime(LocalDateTime.now())
                .build();

        return this.saveImage(image);
    }
}
