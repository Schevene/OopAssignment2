/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignmenttwo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author schev
 */
public class LaunchComicsView extends Application {
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //instantiate the loader
        FXMLLoader loader = new FXMLLoader();
        //load the fxml file
        //getClass gets to root director of class
        loader.setLocation(getClass().getResource("ComicsView.fxml"));
        Parent parent = loader.load();
        //initialize the scene 
        Scene scene = new Scene(parent);
        
        primaryStage.setTitle("Comic Collection Record");
        //loads scene on to window
        primaryStage.setScene(scene); 
        //shows the stage
        primaryStage.show();
}
}
