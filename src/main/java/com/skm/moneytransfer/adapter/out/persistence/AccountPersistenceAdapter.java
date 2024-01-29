package com.skm.moneytransfer.adapter.out.persistence;

import com.skm.moneytransfer.application.port.out.LoadAccountPort;
import com.skm.moneytransfer.application.port.out.UpdateAccountPort;
import com.skm.moneytransfer.common.PersistenceAdapter;
import com.skm.moneytransfer.domain.Account;

@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new); // mejorar exception
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}
