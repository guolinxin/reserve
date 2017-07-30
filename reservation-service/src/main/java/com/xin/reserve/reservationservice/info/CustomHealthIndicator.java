package com.xin.reserve.reservationservice.info;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by linxing on 29/07/2017.
 */

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status("I <3 Target!!!").build();
    }
}
