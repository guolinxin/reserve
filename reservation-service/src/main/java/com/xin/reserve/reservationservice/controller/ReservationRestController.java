package com.xin.reserve.reservationservice.controller;

import com.xin.reserve.reservationservice.dao.ReservationRepository;
import com.xin.reserve.reservationservice.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by linxing on 29/07/2017.
 */


@RestController
public class ReservationRestController {

    //    @Autowired
    //    private ReservationRepository reservationRepository;

    private final ReservationRepository reservationRepository;

    ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservations")
    Collection<Reservation> reservations() {
        return this.reservationRepository.findAll();
    }
}
