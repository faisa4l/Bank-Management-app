package net.javaguide.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	private double balance;
	
	public Account(Long id, String accountHolderName, Double balance) {
	    this.id = id;
	    this.accountHolderName = accountHolderName;
	    this.balance = balance;
	}


}