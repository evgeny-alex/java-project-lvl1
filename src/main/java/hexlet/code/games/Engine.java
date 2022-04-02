package hexlet.code.games;

import hexlet.code.dto.QuestionInfo;

import java.util.Random;
import java.util.Scanner;

public abstract class Engine {

    private String playerName = "";

    private static final int COUNT_ROUNDS = 3;

    protected static final Random RANDOM = new Random();

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Метод возвращает условие игры.
     *
     * @author Evgeny Aleksandrov
     * @version 1.0
     *
     * @return условие игры
     */
    protected abstract String getGameQuestion();

    /**
     * Метод заполняет детали вопроса: описание вопроса и правильный ответ.
     *
     * @param questionInfo - Объект, содержащий информацию о вопросе
     * @author Evgeny Aleksandrov
     * @version 1.0
     */
    protected abstract void fillQuestionInfo(QuestionInfo questionInfo);

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
