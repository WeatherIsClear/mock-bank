package wheatherIsClear.bank.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.Bank;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    AccountRepository accountRepository;

    /**
     *
     */
    @Test
    @DisplayName("초기 계좌 등록 테스트")
    void insertAccount() throws Exception
    {
        //given
        Bank dYBank = bankRepository.findByBankCode(BankCode.DY);
        //when
        Account account = new Account("1", "1234", BigDecimal.valueOf(100000), dYBank);
        accountRepository.save(account);

        //then
//        Account findAccount = accountRepository.findByNumber("1");
//        String findBankName = findAccount.getBank().getName();
//        assertThat(findBankName).isEqualTo(dYBank.getName());
//        assertThat(account.getNumber()).isEqualTo(findAccount.getNumber());

    }

}