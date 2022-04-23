package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class ParityCheck {

    public static final Random RANDOM = new Random();

    private static final int MAX_NUMBER = 20;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    private static final String GAME_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {
        Engine.playGame(GAME_QUESTION, getGameInfo());
    }

    private static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_ROUNDS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_ROUNDS; i++) {
            String[] roundInfo = new String[Engine.COUNT_INFO];

            int number = RANDOM.nextInt(MAX_NUMBER);
            String correctAnswer = (number % 2 == 0) ? YES_ANSWER : NO_ANSWER;

            roundInfo[0] = String.valueOf(number);
            roundInfo[Engine.COUNT_INFO - 1] = correctAnswer;

            gameInfo[i] = roundInfo;
        }
        return gameInfo;
    }
}
