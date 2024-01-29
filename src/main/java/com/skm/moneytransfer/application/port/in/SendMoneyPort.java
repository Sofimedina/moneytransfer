package com.skm.moneytransfer.application.port.in;

public interface SendMoneyPort {
    public boolean send(SendMoneyCommand command);
}