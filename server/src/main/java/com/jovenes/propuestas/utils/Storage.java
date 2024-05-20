package com.jovenes.propuestas.utils;

import com.jovenes.propuestas.base.BaseEntity;
import com.jovenes.propuestas.entities.Project;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Storage {
    private static final String IMAGES_DIRECTORY = "C:\\jvp_data\\images";

    public static <E extends BaseEntity> String transferImage(E entity, MultipartFile file) throws IOException {
        String path = IMAGES_DIRECTORY
                + "/" + entity.getCreatedByUser()
                + "/" + entity.getId();

        return transferFile(path, file);
    }

    private static String transferFile(String path, MultipartFile file) throws IOException {
        // Crea el directorio de carga si no existe
        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        // Guarda la imagen en el directorio de carg
        String fileName = file.getOriginalFilename();
        File destFile = new File(uploadDir.getAbsolutePath() + "/" + fileName);
        file.transferTo(destFile);
        Thumbnails.of(destFile)
                .size(800, 800)  // Redimensionar a un tamaño máximo de 800x800
                .outputQuality(0.8)  // Ajustar la calidad para reducir el tamaño del archivo
                .toFile(destFile);
        return destFile.getAbsolutePath();
    }
}
