package be.technifutur.security.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salle_id", nullable = false)
    private long id;

    @Column(name = "salle_capacity", nullable = false)
    private int capacity;

    @Column(name = "numero_salle", nullable = false, unique = true)
    private long num;

//    @OneToMany(mappedBy = "salle")
//    private List<Material> materials;

    @ManyToMany
    @JoinTable(
            name = "salle_equipment",
            joinColumns = @JoinColumn(name = "salle_equipment_room_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "salle_equipment_equipment_id", nullable = false)
    )
    private List<Material> equipments = new ArrayList<>();

    @OneToMany(mappedBy = "salle")
    private List<Reservation> reservations = new ArrayList<>();


}
