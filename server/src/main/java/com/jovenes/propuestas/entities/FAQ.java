package com.jovenes.propuestas.entities;

import com.jovenes.propuestas.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faqs")
@SQLDelete(sql="UPDATE faqs SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "faq_id"))
public class FAQ extends BaseEntity {

    @Column(nullable=false, length = 50)
    private String question;

    @Column(length = 100)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Proyect proyect;
}
