package com.xin.reserve.reservationservice.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by linxing on 29/07/2017.
 */

@Component
public interface ConsumerChannels {

    @Input
    SubscribableChannel input();
}
