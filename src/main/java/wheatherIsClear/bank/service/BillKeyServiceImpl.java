package wheatherIsClear.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wheatherIsClear.Enums.BankCode;
import wheatherIsClear.bank.entity.Account;
import wheatherIsClear.bank.entity.BillKey;
import wheatherIsClear.bank.repository.AccountRepository;
import wheatherIsClear.bank.repository.BankRepository;
import wheatherIsClear.bank.repository.BillKeyRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillKeyServiceImpl implements BillKeyService{

    private final AccountRepository accountRepository;
    private final BillKeyRepository billKeyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String generateBillKey(String bankCode, String accountNumber, String password) {
        String accountFullNumber = String.format("%s-%s", BankCode.valueOf(bankCode), accountNumber);
        Account findAccount = accountRepository.findByNumber(accountFullNumber).orElse(null);

        if (findAccount != null && passwordEncoder.matches(password, findAccount.getPassword())) {
            BillKey billKey = new BillKey(UUID.randomUUID(), findAccount);
            billKeyRepository.save(billKey);

            return String.valueOf(billKey.getBillKey());
        }
        return null;
    }
}
