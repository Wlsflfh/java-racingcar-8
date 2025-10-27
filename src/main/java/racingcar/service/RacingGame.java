package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ErrorMessage.MUST_BE_POSITIVE_NUMBER;

public class RacingGame {

    private final Cars cars;
    private final int numberOfAttempts;

    public RacingGame(Cars cars, int numberOfAttempts) {
        validateNumberOfAttempts(numberOfAttempts);
        this.cars = cars;
        this.numberOfAttempts = numberOfAttempts;
    }

    private void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException(MUST_BE_POSITIVE_NUMBER.getMessage());
        }
    }

    public List<List<Car>> playRound() {
        List<List<Car>> roundResults = new ArrayList<>();

        for (int i = 0; i < numberOfAttempts; i++) {
            cars.moveCars();

            List<Car> roundCars = cars.getCars().stream()
                    .map(car -> new Car(car.getName(), car.getPosition()))
                    .toList();

            roundResults.add(roundCars);
        }

        return roundResults;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
