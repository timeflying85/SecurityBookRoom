package be.technifutur.security.service.impl;

import be.technifutur.security.model.form.LoginForm;
import be.technifutur.security.service.AuthService;
import be.technifutur.security.model.dto.AuthDTO;
import be.technifutur.security.utils.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;

    private final JwtProvider jwtProvider;


    public AuthServiceImpl(AuthenticationManager authManager, JwtProvider jwtProvider) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
    }


    @Override
    public AuthDTO login(LoginForm form) {

        Authentication auth = new UsernamePasswordAuthenticationToken( form.getUsername(), form.getPassword() );
        auth = authManager.authenticate(auth);
        return new AuthDTO(auth.getName(), jwtProvider.createToken(auth));

    }

}
