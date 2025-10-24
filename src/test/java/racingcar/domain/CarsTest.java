package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarsTest {

    @Test
    @DisplayName("정상적인 자동차 이름들 텍스트에 대하여 정상적으로 처리하는지 확인한다.")
    void carsTest() {
        // given
        List<String> normalCarNames = List.of("tesla", "kia", "benz");

        // when - then
        assertDoesNotThrow(() -> {new Cars(normalCarNames, new CarMoveRandomNumberGenerator());});
    }

    @Test
    @DisplayName("중복된 자동차 이름들 텍스트에 대하여 예외를 발생시키는지 확인한다.")
    void validateDuplicateTest() {
        // given
        List<String> duplicateCarNames = List.of("tesla", "tesla", "benz");

        // when - then
        assertThatThrownBy(() -> new Cars(duplicateCarNames, new CarMoveRandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}