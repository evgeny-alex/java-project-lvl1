package hexlet.code;

import hexlet.code.constants.GameNumber;
import hexlet.code.dto.QuestionInfo;
import hexlet.code.games.*;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private String playerName = "";

    private String gameNumber = "";

    private static final int COUNT_ROUNDS = 3;

    public static final Random RANDOM = new Random();

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Установка игры.
     *
     * @param gameNumber - номер игры
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    public void setGameNumber(String gameNumber) {
        this.gameNumber = gameNumber;
    }

    /**
     * Метод возвращает условие игры.
     *
     * @return условие игры
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    protected String getGameQuestion() {
        String question;

        switch (gameNumber) {
            case GameNumber.PARITY_CHECK -> question = ParityCheck.getGameQuestion();
            case GameNumber.CALCULATOR -> question = Calculator.getGameQuestion();
            case GameNumber.GCD -> question = CommonDivisor.getGameQuestion();
            case GameNumber.PROGRESSION -> question = Progression.getGameQuestion();
            case GameNumber.PRIME -> question = Prime.getGameQuestion();
            default -> question = "";
        }

        return question;
    }

    /**
     * Метод заполняет детали вопроса: описание вопроса и правильный ответ.
     *
     * @param questionInfo - Объект, содержащий информацию о вопросе
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    protected void fillQuestionInfo(QuestionInfo questionInfo) {
        switch (gameNumber) {
            case GameNumber.PARITY_CHECK -> ParityCheck.fillQuestionInfo(questionInfo);
            case GameNumber.CALCULATOR -> Calculator.fillQuestionInfo(questionInfo);
            case GameNumber.GCD -> CommonDivisor.fillQuestionInfo(questionInfo);
            case GameNumber.PROGRESSION -> Progression.fillQuestionInfo(questionInfo);
            case GameNumber.PRIME -> Prime.fillQuestionInfo(questionInfo);
        }
    }

    /**
     * Метод запускает игру.
     *
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    public final void playGame() {
        System.out.println(getGameQuestion());
        for (int i = 0; i < COUNT_ROUNDS; i++) {
            playRound();
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    private void playRound() {
        QuestionInfo question = new QuestionInfo();
        fillQuestionInfo(question);

        System.out.println("Question: " + question.getQuestion());
        System.out.print("Your answer: ");
        String answer = scanner.next();
        String correctAnswer = question.getCorrectAnswer();

        if (correctAnswer.equals(answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n"
                    + "Let's try again, " + playerName + "!");
            System.exit(0);
        }
    }

    public final void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
