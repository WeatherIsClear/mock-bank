package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {



}
