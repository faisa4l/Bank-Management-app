package net.javaguide.banking.service.Impl;

import org.springframework.stereotype.Service;

import net.javaguide.banking.Mapper.AccountMapper;
import net.javaguide.banking.dto.AccountDto;
import net.javaguide.banking.entity.Account;
import net.javaguide.banking.repository.AccountRepository;
import net.javaguide.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

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
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }
}
