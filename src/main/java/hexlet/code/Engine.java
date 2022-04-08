package hexlet.code;

import hexlet.code.constants.GameNumber;
import hexlet.code.dto.QuestionInfo;
import hexlet.code.games.Calculator;
import hexlet.code.games.CommonDivisor;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

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
     * @param newGameNumber - номер игры
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    public void setGameNumber(String newGameNumber) {
        this.gameNumber = newGameNumber;
    }

    /**
     * Метод возвращает условие игры.
     *
     * @return условие игры
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    protected String getGameQuestion() {
        String question = "";

        switch (gameNumber) {
            case GameNumber.PARITY_CHECK -> ParityCheck.fillGameQuestion(question);
            case GameNumber.CALCULATOR -> Calculator.fillGameQuestion(question);
            case GameNumber.GCD -> CommonDivisor.fillGameQuestion(question);
            case GameNumber.PROGRESSION -> Progression.fillGameQuestion(question);
            case GameNumber.PRIME -> Prime.fillGameQuestion(question);
            default -> {
            }
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
            default -> {
            }
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

    /**
     * Установка имени.
     *
     * @param newPlayerName - Имя игрока
     */
    public void setPlayerName(String newPlayerName) {
        this.playerName = newPlayerName;
    }
}
