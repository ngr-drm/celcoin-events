package com.api.celcoinevents.domain.rest.pix.antifraud.key.query.activities;

import com.api.celcoinevents.commands.Command;
import com.api.celcoinevents.commands.SendMessageToSnsTopic;
import com.api.celcoinevents.domain.rest.pix.antifraud.key.query.handlers.EnterpriseException;
import com.api.celcoinevents.providers.aws.sns.topics.CelcoinEventsTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SendEventToTheLake {

    @Autowired
    private CelcoinEventsTopic celcoinEventsTopic;

    public void execute(String event){
        SendMessageToSnsTopic sendMessageToSnsTopic = new SendMessageToSnsTopic(lambaCommand());
        sendMessageToSnsTopic.execute(event);
    }

    private Command<String> lambaCommand () {
        return (String message) -> {
            try {
                celcoinEventsTopic.publish(message);
            } catch (Exception e) {
                throw new EnterpriseException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        "message could not be published"
                );
            }
        };
    }


}
