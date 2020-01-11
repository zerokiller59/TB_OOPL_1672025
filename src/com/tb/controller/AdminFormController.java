package com.tb.controller;

import com.tb.MainApp;
import com.tb.dao.FilmDaoImpl;
import com.tb.dao.ScreeningDaoImpl;
import com.tb.dao.StudioDaoImpl;
import com.tb.entity.Film;
import com.tb.entity.Screening;
import com.tb.entity.Studio;
import com.tb.entity.User;
import com.tb.util.TextUtil;
import com.tb.util.ViewUtil;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class AdminFormController implements Initializable {

    @FXML
    private DatePicker dpStartAt;
    @FXML
    private TextField timeStartAt;
    @FXML
    private ComboBox<Film> cbMovie;
    @FXML
    private ComboBox<Studio> cbStudio;
    @FXML
    private TableView<Screening> tbScreening;
    @FXML
    private TableColumn<Screening, String> colMovie;
    @FXML
    private TableColumn<Screening, String> colStudio;
    @FXML
    private TableColumn<Screening, String> colStartAt;
    @FXML
    private TableColumn<Screening, String> colDuration;
    @FXML
    private TableColumn<Screening, String> colAgeRating;
    @FXML
    private BorderPane borderPane;

    private LoginFormController mainController;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtPrice;

    public void setMainController(LoginFormController mainController) {
        this.mainController = mainController;
        loginId = mainController.getLoginId();
    }

    private ObservableList<Screening> screenings;

    public ObservableList<Screening> getScreenings() {
        if (screenings == null) {
            screenings = FXCollections.observableArrayList();
            screenings.addAll(getScreeningDao().showAllData());
        }
        return screenings;
    }

    private ObservableList<Film> films;

    public ObservableList<Film> getFilms() {
        if (films == null) {
            films = FXCollections.observableArrayList();
            films.addAll(getFilmDao().showAllData());
        }
        return films;
    }

    private ObservableList<Studio> studios;

    public ObservableList<Studio> getStudio() {
        if (studios == null) {
            studios = FXCollections.observableArrayList();
            studios.addAll(getStudioDao().showAllData());
        }
        return studios;
    }

    private FilmDaoImpl filmDao;

    public FilmDaoImpl getFilmDao() {
        if (filmDao == null) {
            filmDao = new FilmDaoImpl();
        }
        return filmDao;
    }

    private ScreeningDaoImpl screeningDao;

    public ScreeningDaoImpl getScreeningDao() {
        if (screeningDao == null) {
            screeningDao = new ScreeningDaoImpl();
        }
        return screeningDao;
    }

    private StudioDaoImpl studioDao;

    public StudioDaoImpl getStudioDao() {
        if (studioDao == null) {
            studioDao = new StudioDaoImpl();
        }
        return studioDao;
    }

    private User loginId;

    public User getLoginId() {
        return loginId;
    }

    private Screening selectedScreening;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMovie.setItems(getFilms());
        cbStudio.setItems(getStudio());
        tbScreening.setItems(getScreenings());
        colMovie.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getFilm().getTitle());
        });
        colDuration.setCellValueFactory(d -> {
            return new SimpleStringProperty(String.valueOf(d.getValue().getFilm().getDuration()));
        });
        colStudio.setCellValueFactory(d -> {
            return new SimpleStringProperty("Studio " + d.getValue().getStudio().getId());
        });
        colStartAt.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getStartAt().toString());
        });
        colAgeRating.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getFilm().getAgeRating().getName());
        });
    }

    @FXML
    private void closeApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void showUserManagement(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MUserForm.fxml"));
            BorderPane root = loader.load();
            MUserFormController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OOPL");
            stage.initOwner(borderPane.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showMovieManagement(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MMovieForm.fxml"));
            BorderPane root = loader.load();
            MMovieFormController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OOPL");
            stage.initOwner(borderPane.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showStudioManagement(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MStudioForm.fxml"));
            BorderPane root = loader.load();
            MStudioFormController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("OOPL");
            stage.initOwner(borderPane.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showAbout(ActionEvent event) {
        ViewUtil.showAlert(Alert.AlertType.INFORMATION, "About Us", "Arthur D - Reinhart S.");
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        if (selectedScreening != null && !TextUtil.isEmptyField(txtPrice, timeStartAt) && dpStartAt.getValue() != null && cbMovie.getValue() != null && cbStudio.getValue() != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                String screenAt = dpStartAt.getValue().format(formatter) + " " + timeStartAt.getText().trim() + ":00";
                Date date = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(screenAt);
                Screening screening = selectedScreening;
                screening.setFilm(cbMovie.getValue());
                screening.setStudio(cbStudio.getValue());
                screening.setStartAt(date);
                screening.setPrice(Double.valueOf(txtPrice.getText().trim()));
                if (getScreeningDao().updateData(screening) != 1) {
                    ViewUtil.showAlert(Alert.AlertType.ERROR, "Failed to update screen");
                } else {
                    getScreenings().clear();
                    getScreenings().addAll(getScreeningDao().showAllData());
                }
            } catch (ParseException ex) {
                Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!TextUtil.isEmptyField(txtPrice, timeStartAt) && dpStartAt.getValue() != null && cbMovie.getValue() != null && cbStudio.getValue() != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                String screenAt = dpStartAt.getValue().format(formatter) + " " + timeStartAt.getText().trim() + ":00";
                Date date = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(screenAt);
                Screening screening = new Screening();
                screening.setFilm(cbMovie.getValue());
                screening.setStudio(cbStudio.getValue());
                screening.setStartAt(date);
                screening.setPrice(Double.valueOf(txtPrice.getText().trim()));
                if (getScreeningDao().addData(screening) != 1) {
                    ViewUtil.showAlert(Alert.AlertType.ERROR, "Failed to add screen");
                } else {
                    getScreenings().clear();
                    getScreenings().addAll(getScreeningDao().showAllData());
                }
            } catch (ParseException ex) {
                Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
    }

    @FXML
    private void btnResetAction(ActionEvent event) {
        selectedScreening = null;
        timeStartAt.clear();
        dpStartAt.setValue(null);
        cbMovie.setValue(null);
        cbStudio.setValue(null);
        txtPrice.clear();
        btnDelete.setDisable(true);
    }

    @FXML
    private void tbScreeningClickedAction(MouseEvent event) {
        selectedScreening = tbScreening.getSelectionModel().getSelectedItem();
        if (selectedScreening != null) {
            DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat timeF = new SimpleDateFormat("hh:mm");
            String date = dateF.format(selectedScreening.getStartAt());
            String time = timeF.format(selectedScreening.getStartAt());
            cbMovie.setValue(selectedScreening.getFilm());
            cbStudio.setValue(selectedScreening.getStudio());
            dpStartAt.setValue(LocalDate.parse(date));
            timeStartAt.setText(time);
            txtPrice.setText(String.valueOf(selectedScreening.getPrice()));
        }
    }

}
