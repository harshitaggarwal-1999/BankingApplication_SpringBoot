package net.finance.banking.bankingapp.service.impl;

import net.finance.banking.bankingapp.dto.AccountDto;
import net.finance.banking.bankingapp.entity.Account;
import net.finance.banking.bankingapp.mapper.AccountMapper;
import net.finance.banking.bankingapp.repository.AccountRepository;
import net.finance.banking.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not Found"));
        Double total = account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
