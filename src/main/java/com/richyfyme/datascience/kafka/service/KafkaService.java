package com.richyfyme.datascience.kafka.service;

import com.richyfyme.datascience.kafka.model.DSEvent;
import com.richyfyme.datascience.kafka.util.DataScienceCloudEvent;
import io.cloudevents.v1.CloudEventImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(){
        kafkaTemplate.send("topic-new","Mensagem de teste enviada ao tópico");
    }

    @KafkaListener(topics = "topic-new", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("message = " + message);
    }

}
