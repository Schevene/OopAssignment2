/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopassignmenttwo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author schev
 */
public class ComicsViewController implements Initializable {

    
    @FXML
    private Label windowHeaderLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label writerLabel;

    @FXML
    private Label artistLabel;

    @FXML
    private Label publisherLabel;

    @FXML
    private Label releaseYearLabel;

    @FXML
    private TextField titleText;

    @FXML
    private TextField writerText;

    @FXML
    private TextField artistText;

    @FXML
    private ComboBox<String> publisherComboBox;

    @FXML
    private Slider releaseYearSlider;

    @FXML
    private TextField releaseYearSliderText;

    @FXML
    private Label collectionLabel;

    @FXML
    private Label volumeLabel;

    @FXML
    private Spinner<Integer> collectionSpinner;

    @FXML
    private Spinner<Integer> volumeSpinner;
    
    @FXML
    private Button saveButton;

    @FXML
    private Label systemMsgText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Set up the comboxBox to take values from the Comics class
        publisherComboBox.getItems().addAll(Comics.getPublishers());
        
        //Set up release year text field as non-editable       
        this.releaseYearSliderText.setEditable(false);
        
        //Set up the max and min for the release year slider
        releaseYearSlider.setMin(1937);
        releaseYearSlider.setMax(LocalDate.now().getYear());
        
        //Call a method to update the year text field to the selected
        //year on the slider
        updateReleaseYearText();
        
        //Value factory to set up the collection spinner and its max and min
        //values
        SpinnerValueFactory<Integer> valueFactory = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 15);
 
        collectionSpinner.setValueFactory(valueFactory);
        
        //Value factory to set up the volume spinner and its max and min
        //values
           SpinnerValueFactory<Integer> valueFactory2 = 
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 15);
 
        volumeSpinner.setValueFactory(valueFactory2);
        
        //set the system message to blank until there is success or failure
        systemMsgText.setText(" ");
    }    
    
    /**
     * This method will update the release year text field to reflect the
     * current position of the slider
     */
     public void updateReleaseYearText()
    {
        releaseYearSliderText.setText(String.format("%.0f", 
                releaseYearSlider.getValue()));
    }
     
    /**
     * This method will allow the button to save the contents of GUI
     */
     public void saveForm()
     {
          try {
        Comics newComic = new Comics(this.titleText.getText(), 
                            this.publisherComboBox.getValue(),
                            this.writerText.getText(), 
                            this.artistText.getText(),
                            this.collectionSpinner.getValue(),
                            this.volumeSpinner.getValue(),
                            this.releaseYearSlider.getValue()
        );
        String result = newComic.toString();
        System.out.printf("New Comic:%n %s%n", result);
        this.systemMsgText.setText("Success!! Comic saved to file.");
        produceTextFile(result);
        }catch(IllegalArgumentException error)
        {
            this.systemMsgText.setText(error.getMessage());
        }
     }
     
     /**
      * Write to a file
      */
   public void produceTextFile(String result) 
        {
          try (Writer outputStream = new FileWriter("comicCollection.txt", true))
          {
              outputStream.write(result);
          }
          catch (IOException fileError) 
          {
              System.out.println("Unfortunately, The file cannot be located.");
          }
        }
}