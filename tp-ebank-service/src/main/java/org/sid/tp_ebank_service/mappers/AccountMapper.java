package org.sid.tp_ebank_service.mappers;

import org.sid.tp_ebank_service.dto.BankAccountRequestDTO;
import org.sid.tp_ebank_service.dto.BankAccountResponseDTO;
import org.sid.tp_ebank_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO, bankAccount);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccount;
    }

    public BankAccount fromUpdateRequestDTO(String id, BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO, bankAccount);
        bankAccount.setId(id);
        bankAccount.setCreatedAt(new Date());
        return bankAccount;
    }
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);

        return bankAccountResponseDTO;

    }
}
