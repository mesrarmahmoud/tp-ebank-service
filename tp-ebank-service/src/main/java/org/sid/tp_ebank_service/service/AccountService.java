package org.sid.tp_ebank_service.service;

import org.sid.tp_ebank_service.dto.BankAccountRequestDTO;
import org.sid.tp_ebank_service.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
