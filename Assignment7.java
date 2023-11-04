/**
 * Assignment #7 
 * 
 * Name: Madison Chester
 * Student ID: 1219358478
 * Lecture: MWF 10:10AM-11:00AM
 * Description: This is the driver class for DisplayCirclePane.java and sets the scene and stage of the GUI. 
 * 
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Assignment7 extends Application
{
    public static final int WINSIZE_X = 400, WINSIZE_Y = 400;
    private final String WINTITLE = "Assignment7: Drawing Circles";

    @Override
    public void start(Stage stage) throws Exception
    {
        DisplayCirclePane rootPane = new DisplayCirclePane();
        rootPane.setPrefSize(WINSIZE_X, WINSIZE_Y);
        Scene scene = new Scene(rootPane, WINSIZE_X, WINSIZE_Y);
        stage.setTitle(WINTITLE);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Technically this is not needed for JavaFX applications. Added just in
     * case.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
