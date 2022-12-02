package com.richyfyme.datascience.kafka.service;

import com.richyfyme.datascience.kafka.model.DSEvent;
import com.richyfyme.datascience.kafka.util.DataScienceCloudEvent;
import io.cloudevents.v1.CloudEventImpl;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Twitter twitter;
    public void sendMessage(){
        kafkaTemplate.send("topic-new","Mensagem de teste enviada ao tópico");
    }

    public List<String> searchtweets() throws TwitterException {
        Query query = new Query("source:twitter4j baeldung");
        QueryResult result = twitter.search(query);

        return result.getTweets().stream()
            .map(item -> item.getText())
            .collect(Collectors.toList());
    }

    @KafkaListener(topics = "topic-new", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("message = " + message);
    }

}
