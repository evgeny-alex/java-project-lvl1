package hexlet.code.games;

import hexlet.code.Engine;

public final class Calculator {

    private static final int MAX_NUMBER = 20;

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String getGameQuestion() {
        return "What is the result of the expression?";
    }

    public static String[][] getGameInfo() {
        String[][] gameInfo = new String[Engine.COUNT_QUESTIONS][Engine.COUNT_INFO];
        for (int i = 0; i < Engine.COUNT_QUESTIONS; i++) {
            String[] questionInfo = new String[Engine.COUNT_INFO];

            int firstNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
            int secondNumber = Engine.RANDOM.nextInt(MAX_NUMBER);
            int operator = Engine.RANDOM.nextInt(OPERATORS.length);

            int answer = calculateExpression(operator, firstNumber, secondNumber);

            questionInfo[0] = firstNumber + " " + OPERATORS[operator] + " " + secondNumber;
            questionInfo[Engine.COUNT_INFO - 1] = String.valueOf(answer);

            gameInfo[i] = questionInfo;
        }
        return gameInfo;
    }

    private static int calculateExpression(int operator, int firstNumber, int secondNumber) {
        switch (OPERATORS[operator]) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
            default -> {
                // Должен быть выброс исключения, но пока пишем ошибку, и выходим из программы
                System.err.println("Для оператора " + OPERATORS[operator] + " не определена логика.");
                System.exit(1);
                return 0;
            }
        }
    }
}
