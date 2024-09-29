package com.api.celcoinevents.commands;

@FunctionalInterface
public interface Command <T> {
    void sendEvent(T event);
}


