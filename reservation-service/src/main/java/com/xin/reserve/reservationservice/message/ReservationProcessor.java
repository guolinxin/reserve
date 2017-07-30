package com.xin.reserve.reservationservice.message;

import com.xin.reserve.reservationservice.dao.ReservationRepository;
import com.xin.reserve.reservationservice.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;

/**
 * Created by linxing on 29/07/2017.
 */

@MessageEndpoint
public class ReservationProcessor {

    @Autowired
    private ReservationRepository reservationRepository;

    public void onNewReservations(Message<String> msg) {
        this.reservationRepository.save(new Reservation(msg.getPayload()));

    }

}
