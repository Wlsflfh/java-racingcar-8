package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarsTest {

    private final CarMoveRandomNumberGenerator carMoveRandomNumberGenerator = new CarMoveRandomNumberGenerator();

    class AlwaysMoveGenerator implements RandomNumberGenerator {

        @Override
        public int generate() {
            return 9;
        }
    }

    @Test
    @DisplayName("정상적인 자동차 이름들 텍스트에 대하여 정상적으로 처리하는지 확인한다.")
    void carsTest() {
        // given
        List<String> normalCarNames = List.of("tesla", "kia", "benz");

        // when - then
        assertDoesNotThrow(() -> {new Cars(normalCarNames, carMoveRandomNumberGenerator);});
    }

    @Test
    @DisplayName("중복된 자동차 이름들 텍스트에 대하여 예외를 발생시키는지 확인한다.")
    void validateDuplicateTest() {
        // given
        List<String> duplicateCarNames = List.of("tesla", "tesla", "benz");

        // when - then
        assertThatThrownBy(() -> new Cars(duplicateCarNames, carMoveRandomNumberGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }


    @Test
    @DisplayName("우승자를 올바르게 찾는지 확인한다.")
    void findWinnerTest() {
        // given
        List<String> carNames = List.of("tesla", "kia", "benz");
        Cars cars = new Cars(carNames, new AlwaysMoveGenerator());

        cars.moveCars();

        // when
        List<Car> winners = cars.getWinners();

        // then
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("tesla", "kia", "benz");
    }
}
