package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;

import java.util.Optional;

public interface BillKeyRepository extends JpaRepository<BillKey, Long> {
    BillKey findByAccount(Account account);
    BillKey findByBillKey(String billKey);
}
