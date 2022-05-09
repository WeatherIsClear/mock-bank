package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByNumber(String number);
}
