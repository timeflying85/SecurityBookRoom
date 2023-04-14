package be.technifutur.security.model.dto;

import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.entity.Reservation;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationDTO {

    private Long id;
    private LocalDate date;
    private LocalTime BeginsAt;
    private LocalTime EndsAt;
    private ReservationStatus status;
//    private long salleNum;
//    private long salleId;
//    private long capacity;
    private SalleDTO salle;
    private String username;

    public static ReservationDTO from(Reservation entity){
        if(entity == null)
            return null;

        ReservationDTO dto = new ReservationDTO();
            dto.setId(entity.getId());
            dto.setDate(entity.getDate());
            dto.setBeginsAt(entity.getBeginsAt());
            dto.setEndsAt(entity.getEndsAt());
            dto.setStatus(entity.getStatus());
//                .salleNum(entity.getSalle().getNum())
//                .salleId(entity.getSalle().getId())
//                .capacity()

//            dto.setUsername(entity.getBookedBy().getUsername());
            dto.setSalle(SalleDTO.from(entity.getSalle()));

        return dto;
    }

}
