package com.reserve.reservationclient.message;

import com.reserve.reservationclient.domain.Reservation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * Created by linxing on 29/07/2017.
 */

@FeignClient("reservation-service")
public interface ReservationReader {

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    Collection<Reservation> read();

}