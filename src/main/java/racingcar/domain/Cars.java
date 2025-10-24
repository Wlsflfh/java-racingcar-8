package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.ErrorMessage.DO_NOT_DUPLICATE_CAR_NAME;

public class Cars {

    private final List<Car> cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public Cars(List<String> carNames, RandomNumberGenerator randomNumberGenerator) {
        this.cars = fromCarNames(carNames);
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(randomNumberGenerator.generate()));
    }

    public List<Car> getWinner() {
        return cars.stream()
                .filter(car -> car.isWinner(findWinnerPosition()))
                .toList();
    }

    private List<Car> fromCarNames(List<String> carNames) {
        List<Car> carsList = carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .toList();

        validateDuplicateName(carsList);
        return carsList;
    }

    private void validateDuplicateName(List<Car> carList) {
        Set<Car> uniqueCars = new HashSet<>(carList);

        if (uniqueCars.size() != carList.size()) {
            throw new IllegalArgumentException(DO_NOT_DUPLICATE_CAR_NAME.getMessage());
        }
    }

    private int findWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
