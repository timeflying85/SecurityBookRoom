package be.technifutur.security.service;

import be.technifutur.security.model.dto.SalleDTO;

import java.util.List;

public interface SalleService {

    SalleDTO getOne(long id);

    List<SalleDTO> getAll();


}
