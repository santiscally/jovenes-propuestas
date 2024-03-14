package com.jovenes.propuestas.entities.base;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique=true, nullable=false)
    protected Integer id;

    @Column(name="DELETED", nullable=true, length=1)
    protected String deleted;

    @Column(name="created_user", nullable=false)
    protected Integer createdByUser;

    @Column(name="created_time", nullable=false)
    protected Date createdTime = new Date(Calendar.getInstance().getTimeInMillis());

    @Column(name="updated_user")
    protected Integer updatedByUser;

    @Column(name="updated_time")
    protected Date updatedTime;
}

