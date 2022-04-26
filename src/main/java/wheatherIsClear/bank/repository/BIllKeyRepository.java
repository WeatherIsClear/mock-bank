package wheatherIsClear.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wheatherIsClear.bank.entity.BillKey;

public interface BIllKeyRepository extends JpaRepository<BillKey, Long> {
}
