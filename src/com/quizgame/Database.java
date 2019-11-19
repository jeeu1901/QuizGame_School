package com.quizgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    /* private static final String[] SUBJECT = {"subject0", "subject1"};*/


    QuizItem item;
    List<QuizItem> allItems = new ArrayList<>();
    List<QuizItem> sport;
    List<QuizItem> italienskKöket;
    List<QuizItem> itemPack = new ArrayList<>();


    private static final String[] QUESTION = {
            //SPORT
            "Subject0 - Question0",
            "Subject0 - Question1",
            "Exakt hur långt är, sedan 1924, ett maratonlopp?",
            "Subject0 - Question3",
            "Subject0 - Question4",
            "Subject0 - Question5",
            "Subject0 - Question6",
            "Subject0 - Question7",
            "Subject0 - Question8",
            "Subject0 - Question9",

            //ITALIENSKA KÖKET
            "Vilken är huvudingrediensen i \"pesto genovese\"?",
            "Subject1 - Question1",
            "Subject1 - Question2",
            "Subject1 - Question3",
            "Subject1 - Question4",
            "Subject1 - Question5",
            "Subject1 - Question6",
            "Subject1 - Question7",
            "Subject1 - Question8",
            "Subject1 - Question9"
    };

    private static final String[] RIGHT_ANSWER = {
            //SPORT
            "Subject0 - RightAnswer0",
            "Subject0 - RightAnswer1",
            "42 195 m",
            "Subject0 - RightAnswer3",
            "Subject0 - RightAnswer4",
            "Subject0 - RightAnswer5",
            "Subject0 - RightAnswer6",
            "Subject0 - RightAnswer7",
            "Subject0 - RightAnswer8",
            "Subject0 - RightAnswer9",

            //ITALIENSKA KÖKET
            "Basilika",
            "Subject1 - RightAnswer1",
            "Subject1 - RightAnswer2",
            "Subject1 - RightAnswer3",
            "Subject1 - RightAnswer4",
            "Subject1 - RightAnswer5",
            "Subject1 - RightAnswer6",
            "Subject1 - RightAnswer7",
            "Subject1 - RightAnswer8",
            "Subject1 - RightAnswer9"
    };
    private static final String[] WRONG_ANSWER = {
            //SPORT
            "Subject0 - Answer0-0", "Subject0 - Answer0-1", "Subject0 - Answer0-2",
            "Subject0 - Answer1-0", "Subject0 - Answer1-1", "Subject0 - Answer1-2",
            "40 000 m", "42 105 m", "39 850 m",
            "Subject0 - Answer3-0", "Subject0 - Answer3-1", "Subject0 - Answer3-2",
            "Subject0 - Answer4-0", "Subject0 - Answer4-1", "Subject0 - Answer4-2",
            "Subject0 - Answer5-0", "Subject0 - Answer5-1", "Subject0 - Answer5-2",
            "Subject0 - Answer6-0", "Subject0 - Answer6-1", "Subject0 - Answer6-2",
            "Subject0 - Answer7-0", "Subject0 - Answer7-1", "Subject0 - Answer7-2",
            "Subject0 - Answer8-0", "Subject0 - Answer8-1", "Subject0 - Answer8-2",
            "Subject0 - Answer9-0", "Subject0 - Answer9-1", "Subject0 - Answer9-2",

            //ITALIENSKA KÖKET
            "Ruccola", "Pinjenötter", "Vitlök",
            "Subject1 - WrongAnswer1-0", "Subject1 - WrongAnswer1-1", "Subject1 - WrongAnswer1-2",
            "Subject1 - WrongAnswer2-0", "Subject1 - WrongAnswer2-1", "Subject1 - WrongAnswer2-2",
            "Subject1 - WrongAnswer3-0", "Subject1 - WrongAnswer3-1", "Subject1 - WrongAnswer3-2",
            "Subject1 - WrongAnswer4-0", "Subject1 - WrongAnswer4-1", "Subject1 - WrongAnswer4-2",
            "Subject1 - WrongAnswer5-0", "Subject1 - WrongAnswer5-1", "Subject1 - WrongAnswer5-2",
            "Subject1 - WrongAnswer6-0", "Subject1 - WrongAnswer6-1", "Subject1 - WrongAnswer6-2",
            "Subject1 - WrongAnswer7-0", "Subject1 - WrongAnswer7-1", "Subject1 - WrongAnswer7-2",
            "Subject1 - WrongAnswer8-0", "Subject1 - WrongAnswer8-1", "Subject1 - WrongAnswer8-2",
            "Subject1 - WrongAnswer9-0", "Subject1 - WrongAnswer9-1", "Subject1 - WrongAnswer9-2"
    };





    public Database() {
        for (int indexQuestion = 0; indexQuestion < QUESTION.length; indexQuestion++) {

            //skapar en tillfälligt wrongAnswer list som blir parameter i new QuizItem
            ArrayList<String> wrongAnswer = new ArrayList<>();
            for (int indexWrongAnswer = 0; indexWrongAnswer < 3; indexWrongAnswer++)
                wrongAnswer.add(WRONG_ANSWER[(3 * indexQuestion) + indexWrongAnswer]);  //koordinerar 10 String(Q) med 30 String(A)
            QuizItem item = new QuizItem(QUESTION[indexQuestion], RIGHT_ANSWER[indexQuestion], wrongAnswer);
            allItems.add(item);
        }
        sport = allItems.subList(0,9);                      // numbers... :( det blir 10 items utan att kunna förändra antalet!!!
        italienskKöket = allItems.subList(10,19);           // men det är bra förtillfället :)
        //bara för att skicka något
    }

    //inte längre getitem: nu skickar vi ett helt paket med 4(n) frågor (listan är shuffled) om italienska köket.
    public List<QuizItem> getItemPack(){    // n-frågorspaket om en särskild subject
        Collections.shuffle(italienskKöket);//italienskKoket ska bli en variabel som beror på users val
        for (int i=0; i<4; i++)             // till i<4  4 ska bli en variabel som beror på properties
            itemPack.add(italienskKöket.get(i));
        //eller utan loop
        /*questionList = italienskKöket.subList(0,4);*/
        return itemPack;
    }


}