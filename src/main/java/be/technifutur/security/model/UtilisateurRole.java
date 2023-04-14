package be.technifutur.security.model;

import lombok.Getter;


@Getter
public enum UtilisateurRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private final String authority;
    UtilisateurRole(String authority){
        this.authority = authority;
    }

}
