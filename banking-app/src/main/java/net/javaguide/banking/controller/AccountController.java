package net.javaguide.banking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguide.banking.dto.AccountDto;
import net.javaguide.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	// ✅ POST: Add new account
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

	@GetMapping
	public String index() {
		return "Account POST endpoint is working. Please use POST request to add data.";
	}
  // Get account Rest API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountDto = accountService.getAccountById(id);
		
		return ResponseEntity.ok(accountDto);
		
	}
}
