package wheatherIsClear.bank.service;

import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;

import java.math.BigDecimal;

public interface TransactionService {

    Boolean checkBillKey(String billKey);

    BigDecimal trade(String billKey, String to, BigDecimal amount);

}
