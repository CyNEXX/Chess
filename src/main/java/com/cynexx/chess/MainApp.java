package com.cynexx.chess;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.cynexx.chess.models.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainApp extends Application {

    private static Stage stage;
    private static Parent static_classicGame;

    @Override
    public void start(Stage stage) throws Exception {
        MainApp.stage = stage;
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        //Parent classicGame = (VBox) FXMLLoader.load(getClass().getResource("/fxml/ClassicGame.fxml"));
      //  static_classicGame = classicGame;
        System.out.println("Original root toString()" + mainMenu.toString());
        Scene scene = new Scene(mainMenu);
        scene.getStylesheets().add("/styles/Styles.css");
        System.out.println("Orignal stage toString() " + stage);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as fallback in case the application can not be launched through deployment artifacts, e.g., in IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return MainApp.stage;
    }

    public static void bringGameClassic() {

     /*   try {
            Scene scene = new Scene(static_classicGame);
            scene.getStylesheets().add("/styles/classicgame.css");
            System.out.println("Orignal stage toString() " + stage);
            stage.setTitle("Chess");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
        }*/
    }

}
