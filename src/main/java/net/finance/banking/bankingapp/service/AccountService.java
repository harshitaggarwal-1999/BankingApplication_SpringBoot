package net.finance.banking.bankingapp.service;

import net.finance.banking.bankingapp.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto depositAmount(Long id, Double Balance);

    AccountDto withDrawAmount(Long id, Double Balance);
}
