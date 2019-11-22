package com.quizgame;

import java.io.Serializable;
import java.util.ArrayList;

public class QuizItem implements Serializable{
    String question;
    String rightAnswer;
    ArrayList<String> wrongAnswer = new ArrayList<>(4);

    public QuizItem(String question, String rightAnswer, ArrayList<String> wrongAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public ArrayList<String> getWrongAnswer() {
        return wrongAnswer;
    }
}