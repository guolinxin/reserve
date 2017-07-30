package com.xin.reserve.reservationservice.config;

import com.xin.reserve.reservationservice.dao.ReservationRepository;
import com.xin.reserve.reservationservice.message.ConsumerChannels;
import com.xin.reserve.reservationservice.model.Reservation;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.support.GenericHandler;

/**
 * Created by linxing on 29/07/2017.
 */

@EnableBinding(ConsumerChannels.class)
@EnableDiscoveryClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@Configuration
public class AppConfiguration {

    @Bean
    IntegrationFlow inboundReservationFlow(ConsumerChannels channels,
                                           ReservationRepository rr) {
        return IntegrationFlows
                .from(channels.input())
                .handle((GenericHandler<String>) (reservationName, headers) -> {
                    rr.save(new Reservation(reservationName));
                    return null;
                })
                .get();
    }
}
