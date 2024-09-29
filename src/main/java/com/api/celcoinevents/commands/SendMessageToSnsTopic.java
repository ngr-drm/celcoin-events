package com.api.celcoinevents.commands;

public class SendMessageToSnsTopic {
    private final Command<String> command;

    public SendMessageToSnsTopic(Command<String> command) {
        this.command = command;
    }

    public void execute(String event) {
        command.sendEvent(event);
    }
}
