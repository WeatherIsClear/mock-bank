package wheatherIsClear.bank.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BillKeyRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class BillKeyServiceImplTest {

    @Autowired
    BillKeyService billKeyService;
    @Autowired
    BillKeyRepository billKeyRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    void successBillKeyGenerateTest() {
        Account findAccount = accountRepository.findByNumber("DY-123-456-789").orElse(null);
        billKeyService.generateBillKey("DY", "123-456-789");
        BillKey findBillKey = billKeyRepository.findByAccount(findAccount);
        assertThat(findBillKey).isNotNull();
    }


}