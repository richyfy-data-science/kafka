package com.richyfyme.datascience.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

  @GetMapping("/")
  public String test(){
    return "test";
  }

}
