package racingcar.controller;

import racingcar.domain.CarMoveRandomNumberGenerator;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Cars cars = new Cars(inputView.readCarNames(), new CarMoveRandomNumberGenerator());
        int numberOfAttempts = inputView.readNumberOfAttempts();

        outputView.printProgressHeader();
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.moveCars();
            outputView.printProgress(cars.getCars());
        }

        outputView.printWinner(cars.getWinner());
    }
}
