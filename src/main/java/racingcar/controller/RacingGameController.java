package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarMoveRandomNumberGenerator;
import racingcar.domain.Cars;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

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

        RacingGame racingGame = new RacingGame(cars, numberOfAttempts);

        outputView.printProgressHeader();
        List<List<Car>> roundResults = racingGame.playRound();
        for (List<Car> roundResult : roundResults) {
            outputView.printProgress(roundResult);
        }

        outputView.printWinner(racingGame.getWinners());
    }
}
