package com.jovenes.propuestas.entities;

import com.jovenes.propuestas.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "proyects")
@SQLDelete(sql="UPDATE proyects SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "pro_id"))
public class Proyect extends BaseEntity {

    @Column(nullable=false, length = 50)
    private String title;

    @Column(nullable=false, length = 100)
    private String subtitle;

    @Column(nullable=false, length = 4000)
    private String description;

    @Column(nullable=false)
    private double goal;

    @Column(name="limit_date", nullable=false)
    private Date limitDate;

    @Column(name="collected_funds", nullable=false)
    private double collectedFunds;

    @Column(nullable=false, length = 50)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "own_id", nullable = false)
    private Owner owner;

    @OneToMany(mappedBy = "proyect", fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(mappedBy = "proyect", fetch = FetchType.LAZY)
    private List<Update> updates;

    @OneToMany(mappedBy = "proyect", fetch = FetchType.LAZY)
    private List<Reward> rewards;

    @OneToMany(mappedBy = "proyect", fetch = FetchType.LAZY)
    private List<FAQ> faqs;
}
