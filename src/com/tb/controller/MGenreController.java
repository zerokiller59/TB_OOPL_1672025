package com.tb.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class MGenreController implements Initializable {

    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtGenre;
    @FXML
    private TableView<?> tbGenre;
    @FXML
    private TableColumn<?, ?> colGenre;

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

    @FXML
    private void btnUpdateAction(ActionEvent event) {
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
    }

    @FXML
    private void tbGenreClickedAction(MouseEvent event) {
    }

}
