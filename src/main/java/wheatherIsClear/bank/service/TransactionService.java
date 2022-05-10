package wheatherIsClear.bank.service;

import wheatherIsClear.bank.entity.Account;

import java.math.BigDecimal;

public interface TransactionService {

    boolean checkBillKey(String billKey);

    BigDecimal trade(String billKey, String to, String from, BigDecimal amount);

}
