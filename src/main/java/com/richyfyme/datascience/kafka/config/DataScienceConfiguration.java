package com.richyfyme.datascience.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class DataScienceConfiguration {

  @Value("${twitter.oauth.consumerKey}")
  private String consumerKey;
  @Value("${twitter.oauth.consumerSecret}")
  private String consumerSecret;
  @Value("${twitter.oauth.accessToken}")
  private String accessToken;
  @Value("${twitter.oauth.accessTokenSecret}")
  private String accessTokenSecret;

  @Bean
  public Twitter twitter(){
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKey)
        .setOAuthConsumerSecret(consumerSecret)
        .setOAuthAccessToken(accessToken)
        .setOAuthAccessTokenSecret(accessTokenSecret);
    TwitterFactory tf = new TwitterFactory(cb.build());
    return tf.getInstance();
  }

}
