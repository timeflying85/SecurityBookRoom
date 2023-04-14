package be.technifutur.security.service;

import be.technifutur.security.model.dto.MaterialDTO;

import java.util.List;

public interface MaterialService {

    MaterialDTO getOne(long id);

    List<MaterialDTO> getAll();

}
