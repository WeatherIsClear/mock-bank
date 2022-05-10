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
    private Account to_id;

    @ManyToOne
    @JoinColumn(name = "from_id")
    private Account from_id;

    @ManyToOne
    @JoinColumn(name = "bill_key_id")
    private BillKey billKey;

    public Transaction(BigDecimal amount, BigDecimal restAmount, TransactionType type, Account to_id, Account from_id, BillKey billKey) {
        this.amount = amount;
        this.restAmount = restAmount;
        this.type = type;
        this.to_id = to_id;
        this.from_id = from_id;
        this.billKey = billKey;
    }




}
