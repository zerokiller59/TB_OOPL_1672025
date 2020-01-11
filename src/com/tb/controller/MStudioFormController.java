package com.tb.controller;

import com.tb.dao.StudioDaoImpl;
import com.tb.entity.Studio;
import com.tb.util.HibernateUtil;
import com.tb.util.ViewUtil;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class MStudioFormController implements Initializable {

    @FXML
    private TableView<Studio> tbStudio;
    @FXML
    private TableColumn<Studio, String> colStudio;
    @FXML
    private TableColumn<Studio, String> colStudioCapacity;

    private AdminFormController mainController;

    public void setMainController(AdminFormController mainController) {
        this.mainController = mainController;
        tbStudio.setItems(mainController.getStudio());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colStudio.setCellValueFactory(d -> {
            return new SimpleStringProperty("Studio " + d.getValue().getId());
        });
        colStudioCapacity.setCellValueFactory(d -> {
            return new SimpleStringProperty(String.valueOf(d.getValue().getCapacity()));
        });
    }

    @FXML
    private void btnAddNewStudioAction(ActionEvent event) {
        Studio s = new Studio();
        s.setCapacity(240);
        if (mainController.getStudioDao().addData(s) == 0) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Failed to add new studio");
//            for (char row = 'A'; row <= 'L'; row++) {
//                for (int i = 1; i <= 20; i++) {
//                    Seat seat = new Seat();
//                    seat.setRow(row);
//                    seat.setNumber(i);
//                    seat.setStudio(s);
//                    mainController.getStudioDao().addSeatsToStudio(seat);
//                }
//            }
        } else {
            mainController.getStudio().clear();
            mainController.getStudio().addAll(mainController.getStudioDao().showAllData());
        }
    }

    @FXML
    private void btnDelSelectedStudioAction(ActionEvent event) {
    }

}
