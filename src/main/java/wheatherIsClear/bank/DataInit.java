package wheatherIsClear.bank;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.Bank;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BankRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final BankRepository bankRepository;
    private final AccountRepository accountRepository;

    @PostConstruct
    private void init() {
        Bank dyBank = new Bank(BankCode.DY.getBankName(), BankCode.DY);
        Bank tyBank = new Bank(BankCode.TY.getBankName(), BankCode.TY);
        Bank sjBank= new Bank(BankCode.SJ.getBankName(), BankCode.SJ);

        bankRepository.save(dyBank);
        bankRepository.save(tyBank);
        bankRepository.save(sjBank);

        Account dyBankAccount = new Account("123-456-789", "1234", BigDecimal.valueOf(10000L), dyBank);
        Account tyBankAccount = new Account("234-567-890", "1234", BigDecimal.valueOf(10000L), tyBank);
        Account sjBankAccount = new Account("345-678-901", "1234", BigDecimal.valueOf(10000L), sjBank);

        accountRepository.save(dyBankAccount);
        accountRepository.save(tyBankAccount);
        accountRepository.save(sjBankAccount);
    }

}
