package wheatherIsClear.Enums;

import lombok.Getter;

@Getter
public enum BankCode {
    TY("태영은행"), SJ("선제은행"), DY("동영은행");

    private String bankName;

    BankCode(String bankCode) {
        this.bankName = bankCode;
    }
}
