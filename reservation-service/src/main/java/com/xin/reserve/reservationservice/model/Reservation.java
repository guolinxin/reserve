package com.xin.reserve.reservationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by linxing on 29/07/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String reservationName;


    public Reservation(String reservationName) {
        this.reservationName = reservationName;
    }

}
