package be.technifutur.security.controller;

import be.technifutur.security.model.dto.SalleDTO;
import be.technifutur.security.service.SalleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController {

    private final SalleService salleService;


    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/{id:[0-9]+}")
    public SalleDTO getOne(@PathVariable long id){

        return salleService.getOne(id);
    }

    @GetMapping("/all")
    public List<SalleDTO> getAll(){

        return salleService.getAll();
    }

}
