package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String COMMA_DELIMITER = ",";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";


    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return splitCarNames(validateNull(userInput()));
    }

    public int readNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS_MESSAGE);
        return validateNumeric(userInput());
    }

    private List<String> splitCarNames(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(COMMA_DELIMITER)).toList();
    }

    private String validateNull(String inputCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        return inputCarNames;
    }

    private int validateNumeric(String numberOfAttempts) {
        try {
            return Integer.parseInt(numberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    private String userInput() {
        return Console.readLine();
    }
}
