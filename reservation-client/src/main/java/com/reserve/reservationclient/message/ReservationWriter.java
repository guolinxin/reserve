package com.reserve.reservationclient.message;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by linxing on 29/07/2017.
 */
@MessagingGateway
public interface ReservationWriter {

    @Gateway(requestChannel = ProducerChannels.OUTPUT)
    void write(String rn);
}
