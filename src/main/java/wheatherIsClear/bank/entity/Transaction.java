package wheatherIsClear.bank.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wheatherIsClear.Enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @GeneratedValue
    @Id
    @Column(name = "transaction_id")
    private Long id;
    private BigDecimal amount;
    private BigDecimal restAmount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "to_id")
    private Account toAccount;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "bill_key_id")
    private BillKey billKey;

    public Transaction(BigDecimal amount, BigDecimal restAmount, TransactionType type, Account toAccount, Account fromAccount, BillKey billKey) {
        this.amount = amount;
        this.restAmount = restAmount;
        this.type = type;
        this.toAccount = toAccount;
        this.fromAccount = fromAccount;
        this.billKey = billKey;
    }




}
