package be.technifutur.security.model.form;

import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.entity.Reservation;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationInsertForm {

    @NotNull
    @Future
    private LocalDate date;

    @NotNull
    private LocalTime BeginsAt;

    @NotNull
    private LocalTime EndsAt;

    @NotNull
    private ReservationStatus status;

    @Positive
    private long utilisateurId;

    @Positive
    private long salleNum;


    public Reservation toEntity() {

        Reservation reservation = new Reservation();

        reservation.setDate(date);
        reservation.setBeginsAt(BeginsAt);
        reservation.setEndsAt(EndsAt);
        reservation.setStatus(status);

        return reservation;
    }


}
