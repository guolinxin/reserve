package com.reserve.reservationclient.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by linxing on 29/07/2017.
 */
public interface ProducerChannels {

    String OUTPUT = "output";

    @Output(OUTPUT)
    MessageChannel output();
}