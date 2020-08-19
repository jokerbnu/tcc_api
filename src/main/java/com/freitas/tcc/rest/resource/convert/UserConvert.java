package com.freitas.tcc.rest.resource.convert;

import com.freitas.tcc.entity.Address;
import com.freitas.tcc.entity.User;
import com.freitas.tcc.rest.resource.dto.RegisterDTO;

public class UserConvert {

    public static User registerDtoToUser(RegisterDTO registerDTO) {
        var user = new User();
        var address = new Address();

        address.setCity(registerDTO.getCity());
        address.setComplement(registerDTO.getComplement());
        address.setNeighborhood(registerDTO.getNeighborhood());
        address.setNumber(registerDTO.getNumber());
        address.setStreet(registerDTO.getStreet());
        address.setUf(registerDTO.getUf());

        user.setAddress(address);

        user.setBirthDate(registerDTO.getBirthDate());
        user.setEmail(registerDTO.getEmail());
        user.setName(registerDTO.getName());
        user.setPassword(registerDTO.getPassword());
        user.setPhone(registerDTO.getPhone());

        return user;
    }
}
