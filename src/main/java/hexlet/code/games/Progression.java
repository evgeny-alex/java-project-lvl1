package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression {

    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MAX_STEP = 5;

    private static final int MIN_STEP = 1;

    private static final int MAX_LENGTH = 15;

    private static final int MIN_LENGTH = 5;

    public static String getGameQuestion() {
        return "What number is missing in the progression?";
    }

    public static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_QUESTIONS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_QUESTIONS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int firstNumber = Engine.RANDOM.nextInt(MAX_FIRST_NUMBER);
            int step = Engine.RANDOM.nextInt(MIN_STEP, MAX_STEP);
            int length = Engine.RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH);

            int[] progression = getProgressionByParams(firstNumber, step, length);

            int numberAnswer = Engine.RANDOM.nextInt(progression.length);
            StringBuilder question = new StringBuilder();

            for (int j = 0; j < progression.length; j++) {
                if (j == numberAnswer) {
                    question.append(".. ");
                } else {
                    question.append(progression[j]).append(" ");
                }
            }

            questionInfo[0] = String.valueOf(question);
            questionInfo[Engine.COUNT_INFO - 1] = String.valueOf(progression[numberAnswer]);

            gameInfo[i] = questionInfo;
        }
        return gameInfo;
    }

    /**
     * Метод заполняет список элементов арифметической прогрессии.
     *
     * @param firstNumber - первое число прогрессии
     * @param step - шаг прогрессии
     * @param length - длина прогрессии
     * @return - массив с элементами прогрессии
     */
    private static int[] getProgressionByParams(int firstNumber, int step, int length) {
        int[] progression = new int[length];
        progression[0] = firstNumber;
        int currentNumber = firstNumber;
        for (int i = 1; i < length; i++) {
            currentNumber += step;
            progression[i] = currentNumber;
        }
        return progression;
    }
}
