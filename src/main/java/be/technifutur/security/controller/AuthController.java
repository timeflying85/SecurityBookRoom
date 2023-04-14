package be.technifutur.security.controller;

import be.technifutur.security.model.dto.AuthDTO;
import be.technifutur.security.model.form.LoginForm;
import be.technifutur.security.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public AuthDTO login(@RequestBody LoginForm form){
        return authService.login(form);
    }
}
