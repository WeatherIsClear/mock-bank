package wheatherIsClear.bank.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wheatherIsClear.Enums.BillKeyStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BillKey {

    @GeneratedValue
    @Id
    @Column(name = "bill_key_id")
    private Long id;
    private String billKey;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Enumerated(EnumType.STRING)
    private BillKeyStatus billKeyStatus;

    public BillKey(UUID billKey, Account account) {
        this.billKey = String.valueOf(billKey);
        this.account = account;
        this.billKeyStatus = BillKeyStatus.ISSUED;
    }
}
