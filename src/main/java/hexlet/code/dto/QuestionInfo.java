package hexlet.code.dto;

public final class QuestionInfo {

    private String question;

    private String correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
    }
}
