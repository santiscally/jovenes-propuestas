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
@Table(name = "users")
@SQLDelete(sql="UPDATE users SET deleted = '1' WHERE id = ?")
@Where(clause="deleted is null")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity {

    @Column(length = 500)
    protected String biography;

    @Column(nullable=false, length = 50, unique = true)
    protected String email;

    @Column(nullable=false, length = 50, unique = true)
    protected String username;

    @Column(nullable=false, length = 50)
    protected String password;

    @Column(name="first_name", nullable=false, length = 50)
    protected String firstName;

    @Column(name="last_name", nullable=false, length = 50)
    protected String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    protected List<Question> questions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    protected List<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}
