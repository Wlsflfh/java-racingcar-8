package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarMoveRandomNumberGenerator;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("시도 횟수에 대하여 양의 정수만 가능한지 확인한다.")
    void validateNameLengthTest() {
        // given
        Cars cars = new Cars(List.of("tesla", "kia", "benz"), new CarMoveRandomNumberGenerator());
        int positiveNumber = 1;
        int zero = 0;
        int negativeNumber = -1;

        // when - then
        assertThatThrownBy(() -> new RacingGame(cars, zero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상 이어야 합니다.");

        assertThatThrownBy(() -> new RacingGame(cars, negativeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상 이어야 합니다.");

        assertDoesNotThrow(() -> {new RacingGame(cars, positiveNumber);});
    }
}
