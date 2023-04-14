package be.technifutur.security.model.form;

import be.technifutur.security.model.entity.Material;
import be.technifutur.security.model.entity.Reservation;
import be.technifutur.security.model.entity.Salle;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SalleInsertForm {

    @NotNull
    private Long id;

    @NotNull
    private Long num;

    @NotNull
    private int capacity;

    @NotNull
    private List<Material> equipments;

    private List<Reservation> reservations;

    @NotNull
    public Salle toEntity() {

        Salle salle = new Salle();

        salle.setId(this.getId());
        salle.setCapacity(this.getCapacity());
        salle.setNum(this.getNum());
        salle.setEquipments(this.getEquipments());
        salle.setReservations(this.getReservations());

        return salle;
    }

}
