package com.jovenes.propuestas.services.interfaces;

import com.jovenes.propuestas.base.BaseEntity;
import com.jovenes.propuestas.entities.Image;
import com.jovenes.propuestas.entities.Project;
import com.jovenes.propuestas.enums.RelatedType;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Image saveImage(Image image);
    <E extends BaseEntity> Image createImage(RelatedType relatedType, E entity, MultipartFile file, String path);
}
