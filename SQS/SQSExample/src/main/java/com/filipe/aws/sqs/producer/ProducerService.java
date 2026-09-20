package com.filipe.aws.sqs.producer;

import com.filipe.aws.sqs.consumer.MessagePayload;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private SqsTemplate sqsTemplate;

    @Value( "${app.sqs.queue.producer}")
    private String queueName;

    public ProducerService(SqsTemplate sqsTemplate ){
        this.sqsTemplate = sqsTemplate;
    }

    public void enviarMensagem(MessagePayload messagePayload ){
        sqsTemplate.send( queueName, messagePayload );
    }
}
