package be.technifutur.security.controller;

import be.technifutur.security.model.ReservationStatus;
import be.technifutur.security.model.dto.ReservationDTO;
import be.technifutur.security.model.form.ReservationInsertForm;
import be.technifutur.security.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid ReservationInsertForm form){

        reservationService.create( form );
    }

    @GetMapping("/all")
    public List<ReservationDTO> getAll() {

        return reservationService.getAll();

    }

//    @PatchMapping(value = "/{id:[0-9]+}/update", params = "status")
//    public void changeStatus(@PathVariable long id, @RequestParam ReservationStatus status){
//        reservationService.updateStatus(id, status);
//    }

    @PatchMapping(value = "/{id:[0-9]+}/accept")
    public void acceptBooking(@PathVariable long id){
        reservationService.updateStatus(id, ReservationStatus.ACCEPTED);
    }

    @PatchMapping(value = "/{id:[0-9]+}/refuse")
    public void refuseBooking(@PathVariable long id){
        reservationService.updateStatus(id, ReservationStatus.REFUSED);
    }

}
