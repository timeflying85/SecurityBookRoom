package be.technifutur.security.model.form;

import be.technifutur.security.model.entity.Material;
import be.technifutur.security.model.entity.Salle;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MaterialInsertForm {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private Salle salle;


    public Material toEntity() {

        Material material = new Material();

        material.setId(this.getId());
        material.setName(this.getName());
        material.setSalle(this.getSalle());

        return material;
    }

}
