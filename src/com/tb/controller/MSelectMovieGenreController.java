package com.tb.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class MSelectMovieGenreController implements Initializable {

    @FXML
    private ComboBox<?> cbGenre;
    @FXML
    private Label txtMovie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
    }

}
