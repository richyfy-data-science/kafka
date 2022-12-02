package com.richyfyme.datascience.kafka.controller;

import com.richyfyme.datascience.kafka.service.KafkaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

@RestController
public class KafkaController {

  @Autowired
  KafkaService kafkaService;

  @GetMapping("/")
  public String test(){
    kafkaService.sendMessage();
    return "test";
  }

  @GetMapping("/search")
  public List<String> search() throws TwitterException {
    return kafkaService.searchtweets();
  }

}
