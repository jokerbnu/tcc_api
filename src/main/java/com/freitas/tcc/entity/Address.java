package com.freitas.tcc.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Column
    private String city;

    @NotNull
    @Column
    private String street;

    @Column
    private String complement;

    @NotNull
    @Column
    private String neighborhood;

    @Column
    private Integer number;

    @OneToOne
    private UF uf;
}
