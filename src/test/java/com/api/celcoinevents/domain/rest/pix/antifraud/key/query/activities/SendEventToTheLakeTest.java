package com.api.celcoinevents.domain.rest.pix.antifraud.key.query.activities;

import com.api.celcoinevents.domain.rest.pix.antifraud.key.query.handlers.EnterpriseException;
import com.api.celcoinevents.providers.aws.sns.topics.CelcoinEventsTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class SendEventToTheLakeTest {
    @InjectMocks
    private SendEventToTheLake sendEventToTheLake;

    @Mock
    private CelcoinEventsTopic celcoinEventsTopic;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldPublishEventSuccessfully() {
        String event = "test-event";
        sendEventToTheLake.execute(event);

        verify(celcoinEventsTopic, times(1)).publish(event);
    }

    @Test
    public void shouldThrowEnterpriseExceptionWhenPublishFails() {
        String event = "test-event";

        doThrow(new RuntimeException("SNS publish error")).when(celcoinEventsTopic).publish(event);

        EnterpriseException exception = assertThrows(EnterpriseException.class, () -> {
            sendEventToTheLake.execute(event);
        });

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusCode());
        assertEquals("message could not be published", exception.getReason());

        verify(celcoinEventsTopic, times(1)).publish(event);
    }
}