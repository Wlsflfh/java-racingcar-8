package racingcar.domain;

import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public void moveCar() {
        position++;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상이여야 합니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
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
