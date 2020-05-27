package com.freitas.tcc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freitas.tcc.enumeration.StatusSugestion;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "sugestion")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sugestion {
    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "id", strategy = "uuid2")
    private UUID id;

    @NotNull
    @Length(max = 255)
    @Column
    private String description;

    @JsonIgnore
    @Column
    private Instant createdAt = Instant.now();

    @Column
    private Integer status = StatusSugestion.PENDING.getId();

    @NotNull
    @OneToOne
    private Address address;

    @NotNull
    @OneToOne
    private User user;
}
