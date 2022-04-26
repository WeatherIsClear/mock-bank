package wheatherIsClear.Enums;

import lombok.Getter;

@Getter
public enum BillKeyStatus {
    ISSUED("정상"), EXPIRED("만료"), DELETED("삭제");

    private final String status;

    BillKeyStatus(String status) {
        this.status = status;
    }
}
