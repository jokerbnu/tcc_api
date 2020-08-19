package com.freitas.tcc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freitas.tcc.enumeration.Role;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tcc_user")
public class User {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Column
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    @Column
    private String phone;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column
    private String password;

    @NotNull
    @OneToOne
    private Address address;

    private Integer role = Role.USER.getId();
}
