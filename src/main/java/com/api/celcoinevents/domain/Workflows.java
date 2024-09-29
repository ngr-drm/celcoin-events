package com.api.celcoinevents.domain;

import com.api.celcoinevents.domain.activities.SendEventToTheLake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/events")
public class Workflows {
    @Autowired
    private SendEventToTheLake sendEventToTheLake;

    @PostMapping
    public ResponseEntity<Void> sendEventToTheLake() throws EnterpriseException{
        String message = "hello world";
        sendEventToTheLake.execute(message);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
