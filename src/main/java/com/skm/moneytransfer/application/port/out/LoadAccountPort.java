package com.skm.moneytransfer.application.port.out;

import com.skm.moneytransfer.domain.Account;

public interface LoadAccountPort {
    Account load(Long id);
}