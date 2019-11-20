package com.quizgame;

import com.quizgame.Controller.QuizController;
import com.quizgame.view.QuizView;

public class QuizProtocol<T> {

    private static final int GETTINGNAME = 0;
    private static final int SUBJECT = 1;
    private static final int CHECKINGANSWER = 2;
    private static final int ANOTHER = 3;

    private int state = GETTINGNAME;
    QuizServer qs;

    public T processQuestion(String answer) {
        String output = "";
        if(state == GETTINGNAME) {
            qs.setNamn(answer);
        }
        else if(state == SUBJECT) {
            // do something
        }
        else if(state == CHECKINGANSWER) {
            // do something
        }
        else if(state == ANOTHER) {
            // do something
        }
        return (T) output;
    }
}
