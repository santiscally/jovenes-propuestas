package com.jovenes.propuestas.entities;

import com.jovenes.propuestas.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rewards")
@SQLDelete(sql="UPDATE rewards SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "rew_id"))
public class Reward extends BaseEntity {

    @Column(nullable=false, length = 500)
    private String title;

    @Column(nullable=false, length = 4000)
    private String description;

    @Column(nullable=false)
    private double price;

    @OneToMany(mappedBy = "reward", fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id", nullable = false)
    private Project project;

}
