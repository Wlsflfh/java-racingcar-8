package racingcar.domain;

import java.util.Objects;

import static racingcar.domain.ErrorMessage.MAX_CAR_NAME_LENGTH;
import static racingcar.domain.ErrorMessage.MIN_CAR_NAME_LENGTH;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int MOVING_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void moveCar(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= MOVING_THRESHOLD;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(MIN_CAR_NAME_LENGTH.getMessage());
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_CAR_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
