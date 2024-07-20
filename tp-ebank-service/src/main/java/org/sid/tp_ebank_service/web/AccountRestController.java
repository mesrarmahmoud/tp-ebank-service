package org.sid.tp_ebank_service.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.sid.tp_ebank_service.dto.BankAccountRequestDTO;
import org.sid.tp_ebank_service.dto.BankAccountResponseDTO;
import org.sid.tp_ebank_service.entities.BankAccount;
import org.sid.tp_ebank_service.mappers.AccountMapper;
import org.sid.tp_ebank_service.repositories.BankAccountRepository;
import org.sid.tp_ebank_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Example Controller", description = "Example API for demonstrating Swagger")
public class AccountRestController{

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;
    private static final String PATH = "/error";


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAcounts/{id}")
    public BankAccount bankAccount(@PathVariable  String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));

    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getId() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt() != null) account.setCreatedAt(new Date());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getBalance() != null ) account.setBalance(bankAccount.getBalance());
        return bankAccountRepository.save(account);

    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }


}
