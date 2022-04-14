package hexlet.code.games;

import hexlet.code.Engine;

public final class ParityCheck {

    private static final int MAX_NUMBER = 20;

    private static final String YES_ANSWER = "yes";

    private static final String NO_ANSWER = "no";

    public static String getGameQuestion() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_QUESTIONS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_QUESTIONS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int number = Engine.RANDOM.nextInt(MAX_NUMBER);
            String correctAnswer = (number % 2 == 0) ? YES_ANSWER : NO_ANSWER;

            questionInfo[0] = String.valueOf(number);
            questionInfo[Engine.COUNT_INFO - 1] = correctAnswer;

            gameInfo[i] = questionInfo;
        }
        return gameInfo;
    }
}
