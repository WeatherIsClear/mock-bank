package wheatherIsClear.bank.service;

import org.springframework.stereotype.Service;
import wheatherIsClear.bank.entity.BillKey;

@Service
public interface BillKeyService {
    String generateBillKey(String bankCode, String accountNumber, String password);

}
