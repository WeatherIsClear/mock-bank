package wheatherIsClear.bank.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wheatherIsClear.Enums.BankCode;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bank {

    @GeneratedValue
    @Id
    @Column(name = "bank_id")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BankCode bankCode;

    protected Bank(String name, BankCode bankCode) {
        this.name = name;
        this.bankCode = bankCode;
    }
}
