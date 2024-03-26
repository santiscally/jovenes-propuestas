package com.jovenes.propuestas.dtos;

import com.jovenes.propuestas.base.BaseDTO;
import com.jovenes.propuestas.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProyectDTO extends BaseDTO {

    private String title;
    private String subtitle;
    private String description;
    private double goal;
    private Date limitDate;
    private double collectedFunds;
    private String category;

}
