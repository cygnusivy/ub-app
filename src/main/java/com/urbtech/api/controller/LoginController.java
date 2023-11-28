package com.urbtech.api.controller;

import com.urbtech.api.dto.response.LoginDtoResponse;
import com.urbtech.api.dto.request.LoginDtoRequest;
import com.urbtech.api.mapper.LoginMapper;
import com.urbtech.domain.model.LoginModel;
import com.urbtech.domain.model.UserModel;
import com.urbtech.domain.repository.UserRepository;
import com.urbtech.domain.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("login")
public class LoginController {

    private LoginService loginService;

    private UserRepository userRepository;

    private LoginMapper loginMapper;

    @PostMapping("/loginUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginDtoResponse logar(@Valid @RequestBody LoginDtoRequest loginDtoRequest){

        LoginModel loginModel = loginService.logar(loginDtoRequest.getEmail(), loginDtoRequest.getSenha());
        LoginDtoResponse loginDtoResponse = loginMapper.loginModelToDto(loginModel);

        Optional<UserModel> userRegistrationModel = userRepository.findByEmail(loginModel.getEmail());
        loginDtoResponse.setIdUser(userRegistrationModel.get().getId());

        return loginDtoResponse;

    }

}