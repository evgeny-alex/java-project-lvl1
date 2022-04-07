package hexlet.code.games;

import hexlet.code.dto.QuestionInfo;

import java.util.ArrayList;
import java.util.List;

public final class Progression extends Engine {

    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MAX_STEP = 5;

    private static final int MIN_STEP = 1;

    private static final int MAX_LENGTH = 15;

    private static final int MIN_LENGTH = 5;

    @Override
    protected String getGameQuestion() {
        return "What number is missing in the progression?";
    }

    @Override
    protected void fillQuestionInfo(QuestionInfo questionInfo) {
        List<Integer> progression = new ArrayList<>();
        fillProgression(progression);

        int numberAnswer = RANDOM.nextInt(progression.size());
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < progression.size(); i++) {
            if (i == numberAnswer) {
                question.append(".. ");
            } else {
                question.append(progression.get(i)).append(" ");
            }
        }
        questionInfo.setCorrectAnswer(String.valueOf(progression.get(numberAnswer)));
        questionInfo.setQuestion(question.toString());
    }

    /**
     * Метод заполняет список элементов арифметической прогрессии.
     *
     * @param progression - список арифметической прогрессии
     */
    private void fillProgression(List<Integer> progression) {
        int firstNumber = RANDOM.nextInt(MAX_FIRST_NUMBER);
        int step = RANDOM.nextInt(MIN_STEP, MAX_STEP);
        int length = RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH);

        progression.add(firstNumber);
        int currentNumber = firstNumber;
        for (int i = 0; i < length; i++) {
            currentNumber += step;
            progression.add(currentNumber);
        }
    }
}
