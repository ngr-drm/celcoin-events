package com.api.celcoinevents.providers.aws.sns;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Setup {
    @Value(("${aws.region}"))
    private String region;
    @Value(("${aws.sns.topic.celcoin-events.arn}"))
    private String celcoinEventsTopicArn;


    @Bean
    public AmazonSNS snsBuilder(){
        return AmazonSNSClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(region)
                .build();
    }

    @Bean(name = "CelcoinEventsTopic")
    public Topic topicBuilder(){
        return new Topic().withTopicArn(celcoinEventsTopicArn);
    }
}
