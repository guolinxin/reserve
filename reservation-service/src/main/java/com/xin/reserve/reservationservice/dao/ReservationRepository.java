package com.xin.reserve.reservationservice.dao;

import com.xin.reserve.reservationservice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by linxing on 29/07/2017.
 */

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @RestResource(path = "by-name")
    Collection<Reservation> findByReservationName(@Param("rn") String name);
}
