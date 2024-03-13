package com.jovenes.propuestas.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proyects")
public class Proyects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
