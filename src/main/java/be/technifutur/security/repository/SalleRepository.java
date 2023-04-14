package be.technifutur.security.repository;

import be.technifutur.security.model.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle, Long> {

        Optional<Salle> findByNum(Long num);


}
