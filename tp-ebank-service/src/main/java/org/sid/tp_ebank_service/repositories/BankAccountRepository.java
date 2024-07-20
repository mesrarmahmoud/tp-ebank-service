package org.sid.tp_ebank_service.repositories;

import org.sid.tp_ebank_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
