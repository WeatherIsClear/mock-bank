package wheatherIsClear.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BillKeyRepository;
import wheatherIsClear.bank.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final BillKeyRepository billKeyRepository;
    private final AccountRepository accountRepository;



    @Override
    public BigDecimal trade(String billKey, String to, String from, BigDecimal amount) {
        if(checkBillKey(billKey)) {
            Account toNumber = accountRepository.findByNumber(to).orElse(null);
            /// billKey와 계좌정보를 어떻게 연동 할 것인지?
        }
    }

    @Override
    public boolean checkBillKey(String billKey) {
        BillKey findBillKey = billKeyRepository.findByBillKey(billKey);
        return findBillKey != null;
    }
}
