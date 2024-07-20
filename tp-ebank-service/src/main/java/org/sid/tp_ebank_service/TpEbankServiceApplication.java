package org.sid.tp_ebank_service;

import org.sid.tp_ebank_service.entities.BankAccount;
import org.sid.tp_ebank_service.enums.AccountType;
import org.sid.tp_ebank_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class TpEbankServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(TpEbankServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return  args -> {
			for (int i=0 ; i<10; i++) {
				BankAccount bankAccount = new BankAccount().builder()
						.id(UUID.randomUUID().toString())
						.createdAt(new Date())
						.type(Math.random()>0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
						.balance(1000 + Math.random()*9000)
						.currency("MAD")
						.build();

				bankAccountRepository.save(bankAccount);

			}
		};
	}

}
