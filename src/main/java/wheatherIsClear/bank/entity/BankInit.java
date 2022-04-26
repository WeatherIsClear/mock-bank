package wheatherIsClear.bank.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Bank;
import wheatherIsClear.bank.repository.BankRepository;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class BankInit {

    @Autowired
    BankRepository bankRepository;

    @PostConstruct
    private void init() {
        Bank bank1 = new Bank(BankCode.DY.getBankName(), BankCode.DY);
        Bank bank2 = new Bank(BankCode.TY.getBankName(), BankCode.TY);
        Bank bank3 = new Bank(BankCode.SJ.getBankName(), BankCode.SJ);

        bankRepository.save(bank1);
        bankRepository.save(bank2);
        bankRepository.save(bank3);
    }

}
