package be.technifutur.security.service;


import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.dto.ReservationDTO;
import be.technifutur.security.model.form.ReservationInsertForm;

import java.util.List;

public interface ReservationService {

    void create(ReservationInsertForm form);

    void updateStatus(long id, ReservationStatus status);

    List<ReservationDTO> getAll();
}
