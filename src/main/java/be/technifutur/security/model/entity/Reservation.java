package be.technifutur.security.model.entity;


import be.technifutur.security.model.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "BeginsAt", nullable = false)
    private LocalTime BeginsAt;

    @Column(name = "EndsAt", nullable = false)
    private LocalTime EndsAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "reservation_utilisateur_id")
    private Utilisateur bookedBy;

    @ManyToOne
    @JoinColumn(name = "reservation_salle_id", nullable = false)
    private Salle salle;

}
