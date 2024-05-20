package com.jovenes.propuestas.entities;

import com.jovenes.propuestas.base.BaseEntity;
import com.jovenes.propuestas.enums.RelatedType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
@SQLDelete(sql="UPDATE images SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "img_id"))
public class Image extends BaseEntity {

    @Column(nullable=false, length = 255)
    private String path;

    @Column(nullable=false, length = 100)
    private String name;

    @Column(nullable=true, length = 400)
    private String description;

    @Column(nullable=false)
    private long size;

    @Column(nullable=false, length = 10)
    private String contentType;

    @Column(name = "related_type", nullable = false) // Tipo de entidad asociada (por ejemplo, "user" o "project")
    private RelatedType relatedType;

    @Column(name = "related_id", nullable = false) // ID de la entidad asociada
    private Integer relatedId;

}