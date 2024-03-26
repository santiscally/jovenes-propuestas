package com.jovenes.propuestas.entities;

import com.jovenes.propuestas.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@SQLDelete(sql="UPDATE addresses SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "add_id"))
public class Address extends BaseEntity {


    @Column(nullable=false, length = 100)
    private String street;

    @Column(length = 10)
    private String floor;

    @Column(length = 10)
    private String apartment;

    @Column(nullable=false, length = 50)
    private String city;

    @Column(nullable=false, length = 50)
    private String province;

    @Column(name="postal_code", nullable=false, length = 50)
    private String postalCode;

    @Column(nullable=false, length = 50)
    private String country;

    @Column(nullable=false, length = 25)
    private String phone;

    @Column(length = 20)
    private String nickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
