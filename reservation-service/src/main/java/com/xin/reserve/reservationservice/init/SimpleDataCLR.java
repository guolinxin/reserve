package com.xin.reserve.reservationservice.init;

import com.xin.reserve.reservationservice.dao.ReservationRepository;
import com.xin.reserve.reservationservice.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by linxing on 29/07/2017.
 */
@Component
public class SimpleDataCLR implements CommandLineRunner {

    @Autowired
    private ReservationRepository reservationRepository;

//    @Autowired
//    public SimpleDataCLR(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Josh", "Heidi", "Cameron", "Saritha",
                "Balaji", "Soumya", "Steve", "Kelsey")
                .forEach(name -> reservationRepository.save(new Reservation(name)));

        reservationRepository.findAll().forEach(System.out::println);
    }


}
