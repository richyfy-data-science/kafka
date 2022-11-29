package com.richyfyme.datascience.kafka.controller;

import com.richyfyme.datascience.kafka.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

  @Autowired
  KafkaService kafkaService;

  @GetMapping("/")
  public String test(){
    kafkaService.sendMessage();
    return "test";
  }

}
