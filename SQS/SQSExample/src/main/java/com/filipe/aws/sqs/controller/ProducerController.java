package com.filipe.aws.sqs.controller;

import com.filipe.aws.sqs.consumer.MessagePayload;
import com.filipe.aws.sqs.producer.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/message" )
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController( ProducerService producerService ){
        this.producerService = producerService;
    }


    @PostMapping( "/send" )
    public ResponseEntity<String> enviarMensagem( @RequestBody MessagePayload payload ){
        producerService.enviarMensagem( payload );
        return ResponseEntity.ok( "Message sent" );
    }
}
