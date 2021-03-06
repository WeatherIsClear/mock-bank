package wheatherIsClear.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wheatherIsClear.Enums.TransactionType;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;
import wheatherIsClear.bank.entity.Transaction;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BillKeyRepository;
import wheatherIsClear.bank.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BillKeyRepository billKeyRepository;
    private final AccountRepository accountRepository;


    @Override
    public BigDecimal trade(String billKey, String to, BigDecimal amount) {
        BillKey findBillKey = checkBillKey(billKey);
        if (findBillKey != null) {
            Account fromAccount = Objects.requireNonNull(billKeyRepository.findByBillKey(billKey).orElse(null)).getAccount();
            Account toAccount = accountRepository.findByNumber(to).orElse(null);
            BigDecimal restAmount = fromAccount.getAmount().subtract(amount);
            if (restAmount.compareTo(BigDecimal.valueOf(0L)) < 0) {
                return BigDecimal.valueOf(-1L);
            } else if (toAccount == null) {
                return BigDecimal.valueOf(-1L);
            }
            fromAccount.withdrawal(amount);
            toAccount.deposit(amount);
            Transaction fromTransaction = new Transaction(amount, restAmount, TransactionType.Withdrawal, toAccount, fromAccount, findBillKey);
            Transaction toTransaction = new Transaction(amount, toAccount.getAmount(), TransactionType.Deposit, toAccount, fromAccount, findBillKey);
            transactionRepository.save(fromTransaction);
            transactionRepository.save(toTransaction);

        }
        return amount;
    }


    @Override
    public BillKey checkBillKey(String billKey) {
        BillKey findBillKey = billKeyRepository.findByBillKey(billKey).orElse(null);
        return findBillKey;
    }
}
