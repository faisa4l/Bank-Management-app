package net.javaguide.banking.service;

import net.javaguide.banking.dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);

	AccountDto getAccountById(Long id);
	

}
