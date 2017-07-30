package com.reserve.reservationclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.reserve.reservationclient.domain.Reservation;
import com.reserve.reservationclient.message.ReservationReader;
import com.reserve.reservationclient.message.ReservationWriter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by linxing on 29/07/2017.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationApiAdapterRestController {

    private final ReservationReader reservationReader;
    private final ReservationWriter reservationWriter;

    ReservationApiAdapterRestController(ReservationWriter reservationWriter,
                                        ReservationReader reservationReader) {
        this.reservationReader = reservationReader;
        this.reservationWriter = reservationWriter;

    }

    public Collection<String> fallback() {
        return new ArrayList<>();
    }

    @PostMapping
    public void write(@RequestBody Reservation r) {
        this.reservationWriter.write(r.getReservationName());
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/names")
    public Collection<String> names() {
        return reservationReader
                .read()
                .stream()
                .map(name -> name.getReservationName())
                .collect(Collectors.toList());
    }
}
