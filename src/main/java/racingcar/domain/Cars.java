package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = fromCarNames(carNames);
    }

    private List<Car> fromCarNames(List<String> carNames) {
        List<Car> carsList = new ArrayList<>();

        for (String carName : carNames) {
            carsList.add(new Car(carName));
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
}
