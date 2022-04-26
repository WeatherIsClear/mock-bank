package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByBankCode(BankCode bankCode);
}
