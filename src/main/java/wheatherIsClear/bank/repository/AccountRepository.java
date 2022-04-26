package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByNumber(String number);
}
