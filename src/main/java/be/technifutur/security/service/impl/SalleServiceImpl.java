package be.technifutur.security.service.impl;

import be.technifutur.security.exceptions.RessourceNotFoundException;
import be.technifutur.security.model.dto.SalleDTO;
import be.technifutur.security.repository.SalleRepository;
import be.technifutur.security.service.SalleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {

    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }


    @Override
    public SalleDTO getOne(long id) {

        return salleRepository.findById(id)
                .map( SalleDTO::from )
                .orElseThrow( RessourceNotFoundException::new );
    }

    @Override
    public List<SalleDTO> getAll() {

        return salleRepository.findAll().stream().map(SalleDTO::from).toList();

    }



}
