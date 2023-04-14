package be.technifutur.security.controller;

import be.technifutur.security.model.dto.MaterialDTO;
import be.technifutur.security.service.MaterialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/{id:[0-9]+}")
    public MaterialDTO getOne(@PathVariable long id) {

        return materialService.getOne(id);
    }

    @GetMapping("/all")
    public List<MaterialDTO> getAll() {

        return materialService.getAll();
    }

}
