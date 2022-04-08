package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.dto.QuestionInfo;

public final class Progression {

    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MAX_STEP = 5;

    private static final int MIN_STEP = 1;

    private static final int MAX_LENGTH = 15;

    private static final int MIN_LENGTH = 5;

    public static void fillGameQuestion(String question) {
        question = "What number is missing in the progression?";
    }

    public static void fillQuestionInfo(QuestionInfo questionInfo) {
        int length = Engine.RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH);
        int[] progression = new int[length];
        fillProgression(progression);

        int numberAnswer = Engine.RANDOM.nextInt(progression.length);
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == numberAnswer) {
                question.append(".. ");
            } else {
                question.append(progression[i]).append(" ");
            }
        }
        questionInfo.setCorrectAnswer(String.valueOf(progression[numberAnswer]));
        questionInfo.setQuestion(question.toString());
    }

    /**
     * Метод заполняет список элементов арифметической прогрессии.
     *
     * @param progression - список арифметической прогрессии
     */
    private static void fillProgression(int[] progression) {
        int firstNumber = Engine.RANDOM.nextInt(MAX_FIRST_NUMBER);
        int step = Engine.RANDOM.nextInt(MIN_STEP, MAX_STEP);

        progression[0] = firstNumber;
        int currentNumber = firstNumber;
        for (int i = 1; i < progression.length; i++) {
            currentNumber += step;
            progression[i] = currentNumber;
        }
    }
}
