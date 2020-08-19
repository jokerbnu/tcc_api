package com.freitas.tcc.rest.resource.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class LoginDTO {
    @NotNull
    private String email;

    @NotNull
    private String password;
}
