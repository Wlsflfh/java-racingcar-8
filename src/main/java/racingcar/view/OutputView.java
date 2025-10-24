package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MOVE_MARK = "-";
    private static final String JOIN_DELIMITER = ", ";
    private static final String PROGRESS_HEADER_MESSAGE = "\n실행 결과";
    private static final String PROGRESS_MESSAGE_FORMAT = "%s : %s%n";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

    public void printProgressHeader() {
        System.out.println(PROGRESS_HEADER_MESSAGE);
    }

    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            String progress = MOVE_MARK.repeat(car.getPosition());
            System.out.printf(PROGRESS_MESSAGE_FORMAT, car.getName(), progress);
        }
        System.out.println();
    }

    public void printWinner(List<Car> winner) {
        String winners = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(JOIN_DELIMITER));

        System.out.printf(WINNER_MESSAGE_FORMAT, winners);
    }
}
