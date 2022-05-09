package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;

public interface BillKeyRepository extends JpaRepository<BillKey, Long> {
    BillKey findByAccount(Account account);
}
