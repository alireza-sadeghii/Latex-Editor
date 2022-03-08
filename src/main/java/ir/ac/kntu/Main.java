package ir.ac.kntu;

import ir.ac.kntu.Coder.Informations;
import ir.ac.kntu.UI.Starter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Alireza Sadeghi
 * @version v1.0
 * main class of latex editor project
 */
public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Informations information = new Informations();
        Starter starter = new Starter(information);

        Scene scene = new Scene(starter.getPane());

        stage.getIcons().add(new Image("icon/iconLog.png"));
        stage.setTitle("LaTex Editor");
        stage.setScene(scene);
        stage.show();
    }
}
