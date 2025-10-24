package racingcar.domain;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다."),
    DO_NOT_DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    MIN_CAR_NAME_LENGTH("자동차 이름은 1글자 이상이여야 합니다."),
    MAX_CAR_NAME_LENGTH("자동차 이름은 5글자 이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}