package com.tb.controller;

import com.tb.dao.FilmDaoImpl;
import com.tb.dao.RatingDaoImpl;
import com.tb.entity.AgeRating;
import com.tb.entity.Film;
import com.tb.util.ViewUtil;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class MMovieFormController implements Initializable {

    @FXML
    private Menu menuSelectedMovie;
    @FXML
    private ComboBox<AgeRating> cbAgeRating;
    @FXML
    private DatePicker dpReleaseDate;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtDirector;
    @FXML
    private TextField txtWriter;
    @FXML
    private TextArea txtSynopsis;
    @FXML
    private TextField txtDuration;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnReset;
    @FXML
    private TableView<Film> tbMovie;
    @FXML
    private TableColumn<Film, String> colTitle;
    @FXML
    private TableColumn<Film, String> colReleaseDate;
    @FXML
    private TableColumn<Film, String> colAgeRating;
    @FXML
    private TableColumn<Film, String> colDuration;
    @FXML
    private TableColumn<Film, String> colGenre;

    private ObservableList<AgeRating> ratings;

    public ObservableList<AgeRating> getRatings() {
        if (ratings == null) {
            ratings = FXCollections.observableArrayList();
            ratings.addAll(getRatingDao().showAllData());
        }
        return ratings;
    }

    private RatingDaoImpl ratingDao;

    public RatingDaoImpl getRatingDao() {
        if (ratingDao == null) {
            ratingDao = new RatingDaoImpl();
        }
        return ratingDao;
    }

    private Film selectedFilm;

    private AdminFormController mainController;

    public void setMainController(AdminFormController mainController) {
        this.mainController = mainController;
        tbMovie.setItems(mainController.getFilms());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbAgeRating.setItems(getRatings());
        colTitle.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getTitle());
        });
        colReleaseDate.setCellValueFactory(d -> {
            SimpleStringProperty property = new SimpleStringProperty();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            property.setValue(dateFormat.format(d.getValue().getReleaseDate()));
            return property;
        });
        colAgeRating.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getAgeRating().getName());
        });
        colDuration.setCellValueFactory(d -> {
            return new SimpleStringProperty(String.valueOf(d.getValue().getDuration()));
        });
        colGenre.setCellValueFactory(d -> {
            return new SimpleStringProperty("Not Yet");
        });
    }

    @FXML
    private void manageGenreAction(ActionEvent event) {
    }

    @FXML
    private void manageSelectedMovieAction(ActionEvent event) {
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        Film f = new Film();
        f.setTitle(txtTitle.getText().trim());
        f.setReleaseDate(Date.from(dpReleaseDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        f.setAgeRating(cbAgeRating.getValue());
        f.setDuration(Integer.valueOf(txtDuration.getText().trim()));
        f.setSynopsis(txtSynopsis.getText().trim());
        f.setDirector(txtDirector.getText().trim());
        f.setWriter(txtWriter.getText().trim());
        if (mainController.getFilmDao().addData(f) != 1) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error adding film");
        }
        mainController.getFilms().clear();
        mainController.getFilms().addAll(mainController.getFilmDao().showAllData());
    }

    @FXML
    private void btnUpdateAction(ActionEvent event) {
        selectedFilm.setTitle(txtTitle.getText().trim());
        selectedFilm.setReleaseDate(Date.from(dpReleaseDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        selectedFilm.setAgeRating(cbAgeRating.getValue());
        selectedFilm.setDuration(Integer.valueOf(txtDuration.getText().trim()));
        selectedFilm.setSynopsis(txtSynopsis.getText().trim());
        selectedFilm.setDirector(txtDirector.getText().trim());
        selectedFilm.setWriter(txtWriter.getText().trim());
        if (mainController.getFilmDao().updateData(selectedFilm) != 1) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error adding film");
        }
        tbMovie.refresh();
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
    }

    @FXML
    private void btnResetAction(ActionEvent event) {
        selectedFilm = null;
        txtTitle.clear();
        dpReleaseDate.setValue(null);
        cbAgeRating.setValue(null);
        txtDuration.clear();
        txtSynopsis.clear();
        txtDirector.clear();
        txtWriter.clear();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    @FXML
    private void tbMovieClickedAction(MouseEvent event) {
        selectedFilm = tbMovie.getSelectionModel().getSelectedItem();
        if (selectedFilm != null) {
            txtTitle.setText(selectedFilm.getTitle());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dpReleaseDate.setValue(LocalDate.parse(dateFormat.format(selectedFilm.getReleaseDate())));
            cbAgeRating.setValue(selectedFilm.getAgeRating());
            txtDuration.setText(String.valueOf(selectedFilm.getDuration()));
            txtSynopsis.setText(selectedFilm.getSynopsis());
            txtDirector.setText(selectedFilm.getDirector());
            txtWriter.setText(selectedFilm.getWriter());
            btnUpdate.setDisable(false);
            btnDelete.setDisable(false);
        }
    }

}
