package wheatherIsClear.bank.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BillKeyRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class TransactionServiceImplTest {
    @Autowired
    TransactionService transactionService;
    @Autowired
    BillKeyService billKeyService;
    @Autowired
    BillKeyRepository billKeyRepository;
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    EntityManager em;

    /**
     * 성공적인 입금 - 보내는 금액이 보유액보다 적고, 올바른 계좌인 경우
     */
    @Test
    void 성공적인_입금() throws Exception
    {
        //given
        String billKey = billKeyService.generateBillKey("DY", "123-456-789", "1234");
        BigDecimal amount = BigDecimal.valueOf(9000L);
        //when
        BigDecimal result = transactionService.trade(billKey, "TY-234-567-890", amount);
        //then
        Assertions.assertThat(result).isEqualTo(BigDecimal.valueOf(9000L));
        Account fromAccount = accountRepository.findByNumber("DY-123-456-789").get();
        Assertions.assertThat(fromAccount.getAmount().setScale(0)).isEqualTo(BigDecimal.valueOf(1000L));
        Account account = accountRepository.findByNumber("TY-234-567-890").get();
        Assertions.assertThat(account.getAmount().setScale(0)).isEqualTo(BigDecimal.valueOf(19000L));
    }

    @Test
    void bigDecimalTest() {
        BigDecimal a = BigDecimal.valueOf(1000L);
        BigDecimal b = BigDecimal.valueOf(900L);
        BigDecimal c = a.subtract(b);

        System.out.println("c = " + c);
    }



}