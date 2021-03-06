package com.demo.uaa.web.rest;

import com.demo.uaa.service.UaaKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/uaa-kafka")
public class UaaKafkaResource {

    private final Logger log = LoggerFactory.getLogger(UaaKafkaResource.class);

    private UaaKafkaProducer kafkaProducer;

    public UaaKafkaResource(UaaKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
