package com.freitas.tcc.rest.resource.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.freitas.tcc.entity.UF;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegisterDTO {
    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String city;

    @NotNull
    private String neighborhood;

    @NotNull
    private String street;

    @OneToOne
    @NotNull
    private UF uf;

    private Integer number;
    private String complement;
}
