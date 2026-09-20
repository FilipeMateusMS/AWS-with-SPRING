package com.filipe.aws.sqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    @SqsListener( "${app.sqs.queue.consumer}" )
    public void listen(MessagePayload message) {
        System.out.println( "Message received: " + message.content() );
    }

}
