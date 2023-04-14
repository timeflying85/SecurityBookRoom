package be.technifutur.security.service.impl;

import be.technifutur.security.exceptions.RessourceNotFoundException;
import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.dto.ReservationDTO;
import be.technifutur.security.model.entity.Reservation;
import be.technifutur.security.model.entity.Salle;
import be.technifutur.security.model.form.ReservationInsertForm;
import be.technifutur.security.repository.ReservationRepository;
import be.technifutur.security.repository.SalleRepository;
import be.technifutur.security.repository.UtilisateurRepository;
import be.technifutur.security.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final SalleRepository salleRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UtilisateurRepository utilisateurRepository, SalleRepository salleRepository) {
        this.reservationRepository = reservationRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public void create(ReservationInsertForm form) {

        Reservation reservation = form.toEntity();

        if( !form.getBeginsAt().isBefore(form.getEndsAt()) )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "start should be before end");

        if( reservationRepository.existsWithConflict(form.getSalleNum(), form.getDate(), form.getBeginsAt(), form.getEndsAt()) )
            throw new ResponseStatusException(HttpStatus.CONFLICT, "room is already used at that time");

//        Utilisateur utilisateur = utilisateurRepository.findById(form.getId())
//                .orElseThrow(RessourceNotFoundException::new);

        Salle salle = salleRepository.findByNum(form.getSalleNum())
                .orElseThrow(RessourceNotFoundException::new);

        reservation.setSalle(salle);
        reservation.setStatus(ReservationStatus.PENDING);
//        reservation.setUtilisateur(utilisateur);

        reservationRepository.save(reservation);

    }

    @Override
    public void updateStatus(long id, ReservationStatus status) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException(Reservation.class));

        if( status == ReservationStatus.PENDING )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cannot change a status to PENDING");

        if( reservation.getStatus() != ReservationStatus.PENDING )
            throw new ResponseStatusException(HttpStatus.CONFLICT, "cant change the status of a booking that is not PENDING");

        reservation.setStatus(status);

        reservationRepository.save(reservation);

    }


    @Override
    public List<ReservationDTO> getAll() {

        return reservationRepository.findAll().stream().map(ReservationDTO::from).toList();

    }
}
