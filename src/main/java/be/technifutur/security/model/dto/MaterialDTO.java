package be.technifutur.security.model.dto;

import be.technifutur.security.model.entity.Material;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaterialDTO {

    private Long id;
    private String name;

    public static MaterialDTO from(Material entity){
        if(entity == null)
            return null;

        return MaterialDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
