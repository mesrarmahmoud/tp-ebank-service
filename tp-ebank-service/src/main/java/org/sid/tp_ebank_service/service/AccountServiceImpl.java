package org.sid.tp_ebank_service.service;

import org.sid.tp_ebank_service.dto.BankAccountRequestDTO;
import org.sid.tp_ebank_service.dto.BankAccountResponseDTO;
import org.sid.tp_ebank_service.entities.BankAccount;
import org.sid.tp_ebank_service.mappers.AccountMapper;
import org.sid.tp_ebank_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {

        BankAccount bankAccount = accountMapper.fromUpdateRequestDTO(id,bankAccountDTO);

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return bankAccountResponseDTO;
    }
}
