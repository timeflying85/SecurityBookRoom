package be.technifutur.security.exceptions;

import be.technifutur.security.model.entity.Reservation;

public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(){
        super("the requested resource was not found");
    }

    public RessourceNotFoundException(Throwable cause){
        super("the requested resource was not found", cause);
    }

    public RessourceNotFoundException(Class<Reservation> reservationClass) {
    }
}