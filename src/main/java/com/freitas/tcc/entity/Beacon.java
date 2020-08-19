package com.freitas.tcc.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "beacon")
public class Beacon implements Serializable {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Column(name = "identity")
    private String identity;

    @NotNull
    @Length(max = 120)
    @Column
    private String message;

    @Min(1)
    @Max(3)
    @Column
    private Integer range = 3;

    @ManyToOne
    private Address address;
}
