package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차의 이름의 길이에 대하여 올바르게 처리하는지 확인한다")
    void validateNameLengthTest() {
        // given
        String emptyCarName = "";
        String longCarName = "Lamborghini";

        // when - then
        assertThatThrownBy(() -> new Car(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1글자 이상이여야 합니다.");

        assertThatThrownBy(() -> new Car(longCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하여야 합니다.");
    }
}
