package com.api.celcoinevents.providers.aws.sns.topics;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CelcoinEventsTopic {
    private final AmazonSNS snsClient;
    private final Topic celcoinEventsTopic;

    public CelcoinEventsTopic(AmazonSNS snsClient, @Qualifier("CelcoinEventsTopic") Topic celcoinEventsTopic){
        this.snsClient = snsClient;
        this.celcoinEventsTopic = celcoinEventsTopic;
    }

    public void publish(String event){
        this.snsClient.publish(celcoinEventsTopic.getTopicArn(), event);
    }

}
