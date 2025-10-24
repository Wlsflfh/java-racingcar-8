package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;
    private final CarMoveRandomNumberGenerator carMoveRandomNumberGenerator;

    public Cars(List<String> carNames, CarMoveRandomNumberGenerator carMoveRandomNumberGenerator) {
        this.cars = fromCarNames(carNames);
        this.carMoveRandomNumberGenerator = carMoveRandomNumberGenerator;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveCar(carMoveRandomNumberGenerator.generate());
        }
    }

    public List<Car> getWinner() {
        List<Car> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.isWinner(findWinnerPosition())) {
                winner.add(car);
            }
        }

        return winner;
    }

    private List<Car> fromCarNames(List<String> carNames) {
        List<Car> carsList = new ArrayList<>();

        for (String carName : carNames) {
            carsList.add(new Car(carName.trim()));
        }

        validateDuplicateName(carsList);
        return carsList;
    }

    private void validateDuplicateName(List<Car> carList) {
        Set<Car> uniqueCars = new HashSet<>(carList);

        if (uniqueCars.size() != carList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private int findWinnerPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
