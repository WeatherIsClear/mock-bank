package wheatherIsClear.Enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    Deposit("입금"),
    Withdrawal("출금");

    private final String type;

    TransactionType(String type) {
        this.type = type;
    }
}
