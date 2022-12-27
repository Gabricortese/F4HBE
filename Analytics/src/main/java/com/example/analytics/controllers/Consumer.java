package com.example.analytics.controllers;

import com.example.analytics.models.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues="analyticsA")
    private void receive (String msg){
        log.info("MessageA: " + msg);
        //System.out.println((Reservation)msg.getCharityact());
    }

    @RabbitListener(queues="analyticsB")
    private void receiveB (String msg){
        log.info("MessageB: " + msg);
        //System.out.println((Reservation)msg.getCharityact());

    }
}
