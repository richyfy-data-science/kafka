package com.richyfyme.datascience.kafka.util;

import com.richyfyme.datascience.kafka.model.DSEvent;
import io.cloudevents.v1.CloudEventBuilder;
import io.cloudevents.v1.CloudEventImpl;
import java.net.URI;
import java.text.MessageFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class DataScienceCloudEvent {

  public CloudEventImpl<DSEvent> buildEventKafka(DSEvent applicationEvent, String eventType) {

    return CloudEventBuilder.<DSEvent>builder().withType(eventType)
        .withId(java.util.UUID.randomUUID().toString())
        .withSource(URI.create(MessageFormat.format("https://localhost:8080", "7877987898")))
        .withDataContentType(MediaType.APPLICATION_JSON_VALUE)
        .withData(applicationEvent)
        .build();
  }


}
