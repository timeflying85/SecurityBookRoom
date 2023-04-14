package be.technifutur.security.service;

import be.technifutur.security.model.form.LoginForm;
import be.technifutur.security.model.dto.AuthDTO;

public interface AuthService {

    AuthDTO login(LoginForm form);

}
