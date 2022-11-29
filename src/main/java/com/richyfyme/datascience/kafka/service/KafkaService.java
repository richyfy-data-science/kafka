package com.richyfyme.datascience.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final TopicProducer topicProducer;

    public void sendMessage(){
        topicProducer.send("Mensagem de teste enviada ao tópico");
    }
}
