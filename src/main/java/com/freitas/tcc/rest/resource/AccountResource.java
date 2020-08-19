package com.freitas.tcc.rest.resource;

import com.freitas.tcc.entity.User;
import com.freitas.tcc.rest.resource.dto.LoginDTO;
import com.freitas.tcc.rest.resource.dto.RegisterDTO;
import com.freitas.tcc.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/account")
public class AccountResource {
    private Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody LoginDTO loginDTO) {
        logger.info("Request with loginDTO: " + loginDTO.toString());
        var user = accountService.login(loginDTO);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.register(registerDTO));
    }

}
