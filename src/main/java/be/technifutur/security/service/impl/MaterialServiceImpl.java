package be.technifutur.security.service.impl;

import be.technifutur.security.exceptions.RessourceNotFoundException;
import be.technifutur.security.model.dto.MaterialDTO;
import be.technifutur.security.repository.MaterialRepository;
import be.technifutur.security.service.MaterialService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    @Override
    public MaterialDTO getOne(long id) {

        return materialRepository.findById(id)
                .map(MaterialDTO::from)
                .orElseThrow(RessourceNotFoundException::new);
    }

    @Override
    public List<MaterialDTO> getAll() {

        return materialRepository.findAll().stream().map(MaterialDTO::from).toList();
    }
}
