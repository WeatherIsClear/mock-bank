package wheatherIsClear.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.Bank;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BankRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataInitTest {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void dataInitTest() {
        Bank dyBank = bankRepository.findByBankCode(BankCode.DY);
        Optional<Account> findAccount = accountRepository.findByNumber("DY-123-456-789");
        Account account = findAccount.orElse(null);
        assertThat(dyBank.getName()).isEqualTo("동영은행");
        assert account != null;
        assertThat(account.getBank().getBankCode()).isEqualTo(BankCode.DY);
        assertThat(findAccount).isPresent();
        System.out.println("account.getPassword() = " + account.getPassword());
        assertThat(passwordEncoder.matches("1234", account.getPassword())).isTrue();
    }

}