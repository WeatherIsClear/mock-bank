package wheatherIsClear.bank.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @GeneratedValue
    @Id
    @Column(name = "accout_id")
    private Long id;
    private String number;
    private String password;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Account(String number, String password, BigDecimal amount, Bank bank) {
        this.number = String.format("%s-%s", bank.getBankCode(), number);
        this.password = password;
        this.amount = amount;
        this.bank = bank;
    }

    public void deposit(BigDecimal depositAmount) {
        this.amount = amount.add(depositAmount);
    }

    public void withdrawal(BigDecimal withdrawalAmount) {
        this.amount = amount.subtract(withdrawalAmount);
    }
}
