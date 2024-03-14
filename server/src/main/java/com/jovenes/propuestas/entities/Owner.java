package com.jovenes.propuestas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "owners")
@SQLDelete(sql="UPDATE owners SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "own_id"))
public class Owner extends User{


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    protected List<Proyect> proyects;

}
