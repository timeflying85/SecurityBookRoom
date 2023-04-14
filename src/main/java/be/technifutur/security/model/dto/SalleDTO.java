package be.technifutur.security.model.dto;

import be.technifutur.security.model.entity.Salle;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SalleDTO {

    private Long id;
    private int capacity;
    private Long num;
    private List<MaterialDTO> equipments;
//    private List<ReservationDTO> reservations;

    public static SalleDTO from(Salle entity) {
        if(entity == null)
            return null;

//        SalleDTO dto = new SalleDTO();
//        dto.setId( entity.getId() );
//        dto.setNum( entity.getNum() );
//        dto.setCapacity( entity.getCapacity() );
//        dto.setEquipments( entity.getMaterials().stream().map(MaterialDTO::from).toList() );
//        dto.setBookings( entity.getReservations().stream().map(ReservationDTO::from).toList() );
//        return dto;

        return SalleDTO.builder()
                .id(entity.getId())
                .capacity(entity.getCapacity())
                .num(entity.getNum())
                .equipments(entity.getEquipments().stream().map(MaterialDTO::from).toList())
//                .reservations( entity.getReservations().stream().map(ReservationDTO::from).toList())
                .build();
    }

}
