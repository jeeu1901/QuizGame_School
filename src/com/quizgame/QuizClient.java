/*
package com.quizgame;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class QuizClient {

    private static int PORT = 12345;
    private Socket socket;
    private ObjectInputStream in;
    private PrintWriter out;
    //----------------------------------- allt det ska bli FX

    private JFrame frame = new JFrame("QuizGame");
    private JLabel label = new JLabel("");
    //----------------------------------- allt det ska bli FX


    public QuizClient(String serverAddress) throws IOException {
        socket = new Socket(serverAddress, PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new ObjectInputStream(socket.getInputStream());
    }


    public void play() throws Exception {
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            //mystiskt men det känns viktigt
            //String serverAddress = (args.length == 0) ? "localhost" : args[1];


            QuizClient client = new QuizClient("localhost");
            QuizItem item = (QuizItem) client.in.readObject();
            //----------------------------------- allt det ska bli FX
            //provar om client får welcome from server
            //client.frame.setTitle(client.in.readLine());
            client.label.setText(item.getQuestion());
            client.frame.add(client.label);
            client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            client.frame.setSize(600, 800);
            client.frame.setVisible(true);
            client.frame.setResizable(true);

            //----------------------------------- allt det ska bli FX
            //



            client.play();

            int playagain = JOptionPane.showConfirmDialog(null, "Again?");
            if (!(playagain == 0)) {
                client.frame.dispose();
                System.exit(0);
            }
            client.frame.dispose();


            //if (!client.wantsToPlayAgain()) {SKAPA METODEN!
            //   break;
        }
    }
}
*/

package com.quizgame;

import com.quizgame.Controller.ChoosingSubjectSceneController;
import com.quizgame.Controller.QuizController;
import com.quizgame.Controller.StartSceneController;
import com.quizgame.view.ChoosingSubjectScene;
import com.quizgame.view.QuizView;
import com.quizgame.view.StartScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizClient extends Application {

    private static int PORT = 12345;
    private Socket socket;
    private ObjectInputStream in;
    private PrintWriter out;
    private Scene scene;
    private ChoosingSubjectScene choosingSubjectScene;
    private QuizView quizView;


    public QuizClient() {    //NO TOUCH THIS!!!!
    }

    public QuizClient(String serverAddress) throws IOException {
        socket = new Socket(serverAddress, PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new ObjectInputStream(socket.getInputStream());
    }
    @Override
    public void start(Stage stage) throws Exception {
        QuizClient quizClient = new QuizClient("127.0.0.1"); // skicka från server ämne!!
        Object fromServer = quizClient.in.readObject();


        /*String toServer= out.println("Football");*/



/*        try {
            while ((fromServer = in.readObject()) != null) {
                if (fromServer instanceof QuizItem) {
                    QuizItem question = (QuizItem) fromServer;
                    *//*anropa rätta metoden*//*
                } else if (fromServer instanceof String) {
                    String message = (String) fromServer;
                    *//*anropa rätta metoden*//*


                } else if (fromServer instanceof Integer[]) {
                    Integer[] points = (Integer[]) fromServer;
                    *//*anropa rätta metoden*//*
                }
            }//while
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/



        stage.setTitle("Quizgame");
        stage.setResizable(false);
        stage.getIcons().add(new Image("/images/quizIcon.png"));


        StartScene startScene = new StartScene();
        choosingSubjectScene = new ChoosingSubjectScene();
        quizView = new QuizView();

        scene = new Scene(startScene.getDesignLayout(),480,620);
        scene.getStylesheets().add(QuizClient.class.getResource("Style.css").toExternalForm());
        stage.setScene(scene);

        StartSceneController startSceneController = new StartSceneController(startScene,this);
        startSceneController.start();

        ChoosingSubjectSceneController choosingSubjectSceneController = new ChoosingSubjectSceneController(choosingSubjectScene,this);
        choosingSubjectSceneController.start();



        //nu är Objektet fromServer som kommer till klienten
        //vi skickar objektet som argument när vi instansierar QuizController
        // i quizControll finns en metod loadItemPack som cast objekt till list<QuizItem> och
        // tar den första item. Sen jobbar vi med en item som förut.

        QuizController quizController = new QuizController(quizView, fromServer);
        quizController.start();
        stage.show();


    }

    public void goToChoseSubjectScene(){
        scene.setRoot(choosingSubjectScene.getDesignLayout());
    }

    public void goToQuizScene() {
        scene.setRoot(quizView.getDesignLayout());
    }

    public static void main(String[] args) {
        launch(args);
    }


}
