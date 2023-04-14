package be.technifutur.security.repository;

import be.technifutur.security.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
        SELECT COUNT(r) > 0
        FROM Reservation r
        WHERE
            r.date = :date AND
            ( r.BeginsAt <= :EndsAt AND r.EndsAt >= :BeginsAt ) AND
            r.salle.id = :id
    """)
    boolean existsWithConflict(Long id, LocalDate date, LocalTime BeginsAt, LocalTime EndsAt);


}
