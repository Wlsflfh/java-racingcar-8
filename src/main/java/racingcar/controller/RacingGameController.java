package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarMoveRandomNumberGenerator;
import racingcar.domain.Cars;
import racingcar.service.RacingGameService;
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

        RacingGameService racingGameService = new RacingGameService(cars, numberOfAttempts);

        outputView.printProgressHeader();
        List<List<Car>> roundResults = racingGameService.playRounds();
        for (List<Car> roundResult : roundResults) {
            outputView.printProgress(roundResult);
        }

        outputView.printWinner(racingGameService.getWinners());
    }
}
