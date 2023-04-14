package be.technifutur.security.utils;

import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.entity.Material;
import be.technifutur.security.model.entity.Reservation;
import be.technifutur.security.model.entity.Salle;
import be.technifutur.security.model.entity.Utilisateur;
import be.technifutur.security.repository.MaterialRepository;
import be.technifutur.security.repository.ReservationRepository;
import be.technifutur.security.repository.SalleRepository;
import be.technifutur.security.repository.UtilisateurRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataInit implements InitializingBean {

    private final SalleRepository salleRepository;

    private final ReservationRepository reservationRepository;

    private final MaterialRepository materialRepository;

    private final UtilisateurRepository utilisateurRepository;

    public DataInit(SalleRepository salleRepository, ReservationRepository reservationRepository, MaterialRepository materialRepository, UtilisateurRepository utilisateurRepository) {
        this.salleRepository = salleRepository;
        this.reservationRepository = reservationRepository;
        this.materialRepository = materialRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Salle salle = new Salle();

        salle.setId(1);
        salle.setNum(1408);
        salle.setCapacity(650);

        salle = salleRepository.save(salle);


        Salle salle1 = new Salle();

        salle1.setId(2);
        salle1.setNum(6666);
        salle1.setCapacity(66);

        salle1 = salleRepository.save(salle1);


        Salle salle2 = new Salle();

        salle2.setId(3);
        salle2.setNum(1803);
        salle2.setCapacity(145);

        salle2 = salleRepository.save(salle2);

//    -----------------------------------------

        Material material = new Material();

        material.setName("Projecteur");
        material.setId(1);

        material = materialRepository.save(material);


        Material material1 = new Material();

        material1.setName("SmartTv");
        material1.setId(2);

        material1 = materialRepository.save(material1);


        Material material2 = new Material();

        material2.setName("Tableau");
        material2.setId(3);

        material2 = materialRepository.save(material2);


//     --------------------------------------------

//        Utilisateur utilisateur = new Utilisateur();
//
//        utilisateur.setId(1);
//        utilisateur.setUsername("timtim");
//        utilisateur.setPassword("Cuicui");
//        utilisateur.setRole("ADMIN");
////        utilisateur.setReservation();
//
//        utilisateur = utilisateurRepository.save(utilisateur);
//
//
//        Utilisateur utilisateur1 = new Utilisateur();
//
//        utilisateur1.setId(2);
//        utilisateur1.setUsername("Maxou");
//        utilisateur1.setPassword("Yop");
//        utilisateur1.setRole("USER");
////        utilisateur.setReservation();
//
//        utilisateur1 = utilisateurRepository.save(utilisateur1);

//     ----------------------------------------------

        Reservation reservation = new Reservation();

        reservation.setId(1);
        reservation.setDate(LocalDate.of(2023, 4, 13));
        reservation.setBeginsAt(LocalTime.parse("10:00:00"));
        reservation.setEndsAt(LocalTime.parse("12:00:00"));
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setBookedBy(null);
        reservation.setSalle(salle);

        reservation = reservationRepository.save(reservation);


        Reservation reservation1 = new Reservation();

        reservation1.setId(2);
        reservation1.setDate(LocalDate.of(2023, 6, 21));
        reservation1.setBeginsAt(LocalTime.parse("19:00:00"));
        reservation1.setEndsAt(LocalTime.parse("22:00:00"));
        reservation1.setStatus(ReservationStatus.PENDING);
        reservation1.setBookedBy(null);
        reservation1.setSalle(salle2);

        reservation1 = reservationRepository.save(reservation1);


    }
}
