package com.jovenes.propuestas.dtos;

import com.jovenes.propuestas.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO extends BaseDTO {

    private String title;
    private String subtitle;
    private String description;
    private double goal;
    private Date limitDate;
    private double collectedFunds;
    private String category;

}
