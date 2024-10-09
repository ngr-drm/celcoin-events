package com.api.celcoinevents.domain.rest.pix.antifraud.key.query;

import com.api.celcoinevents.domain.rest.pix.antifraud.key.query.activities.SendEventToTheLake;
import com.api.celcoinevents.domain.rest.pix.antifraud.key.query.handlers.EnterpriseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/events")
public class Workflows {
    @Autowired
    private SendEventToTheLake sendEventToTheLake;

    @PostMapping
    public ResponseEntity<Void> sendEventToTheLake(@RequestBody Event event) throws EnterpriseException {
        sendEventToTheLake.execute(event.toString());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
