package com.tb.controller;

import com.tb.MainApp;
import com.tb.dao.BalanceDaoImpl;
import com.tb.dao.ScreeningDaoImpl;
import com.tb.dao.TicketDaoImpl;
import com.tb.entity.BalanceHistory;
import com.tb.entity.Screening;
import com.tb.entity.Ticket;
import com.tb.util.ViewUtil;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
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
public class UserScreenFormController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label labelWelcome;
    @FXML
    private TextField txtBalance;
    @FXML
    private TableView<Screening> tbScreening;
    @FXML
    private TableColumn<Screening, String> colMovie;
    @FXML
    private TableColumn<Screening, String> colDuration;
    @FXML
    private TableColumn<Screening, String> colStudio;
    @FXML
    private TableColumn<Screening, String> colStartAt;
    @FXML
    private TableColumn<Screening, String> colAgeRating;
    @FXML
    private TableColumn<Screening, String> colPrice;
    @FXML
    private TableColumn<Screening, String> colSeats;
    @FXML
    private Button btnBuyTicket;

    private LoginFormController mainController;

    public void setMainController(LoginFormController mainController) {
        this.mainController = mainController;
        labelWelcome.setText(mainController.getLoginId().getName());
        txtBalance.setText(String.valueOf(getBalanceDao().countUserBalance(mainController.getLoginId())));
    }

    private BalanceDaoImpl balanceDao;

    public BalanceDaoImpl getBalanceDao() {
        if (balanceDao == null) {
            balanceDao = new BalanceDaoImpl();
        }
        return balanceDao;
    }

    private ScreeningDaoImpl screeningDao;

    public ScreeningDaoImpl getScreeningDao() {
        if (screeningDao == null) {
            screeningDao = new ScreeningDaoImpl();
        }
        return screeningDao;
    }

    private ObservableList<Screening> screenings;

    public ObservableList<Screening> getScreenings() {
        if (screenings == null) {
            screenings = FXCollections.observableArrayList();
            screenings.addAll(getScreeningDao().showAllData());
        }
        return screenings;
    }

    private TicketDaoImpl ticketDao;

    public TicketDaoImpl getTicketDao() {
        if (ticketDao == null) {
            ticketDao = new TicketDaoImpl();
        }
        return ticketDao;
    }

    private Screening selectedScreening;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        colPrice.setCellValueFactory(d -> {
            return new SimpleStringProperty(String.valueOf(d.getValue().getPrice()));
        });
        colSeats.setCellValueFactory(d -> {
            String string = String.valueOf(getTicketDao().countBoughtSeats(d.getValue()));
            return new SimpleStringProperty(string + "/240");
        });
    }

    @FXML
    private void btnViewHistoryAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TransactionHistoryForm.fxml"));
            BorderPane root = loader.load();
            TransactionHistoryFormController controller = loader.getController();
            controller.setUserParam(mainController.getLoginId());
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
    private void btnBuyTicketAction(ActionEvent event) {
        if (getBalanceDao().countUserBalance(mainController.getLoginId()) >= selectedScreening.getPrice()) {
            Ticket ticket = new Ticket();
            ticket.setUser(mainController.getLoginId());
            ticket.setScreening(selectedScreening);
            ticket.setPurchasedAt(new Date());
            int id = getTicketDao().addData(ticket);
            if (id == 0) {
                ViewUtil.showAlert(Alert.AlertType.ERROR, "Can't buy that now");
            } else {
                BalanceHistory balance = new BalanceHistory();
                balance.setUser(mainController.getLoginId());
                balance.setIsTopup(false);
                balance.setValue(selectedScreening.getPrice());
                balance.setDescription(new Date().toString() + "|" + id);
                getBalanceDao().addData(balance);
                txtBalance.setText(String.valueOf(getBalanceDao().countUserBalance(mainController.getLoginId())));
            }
        } else {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Insufficient Funds");
        }
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("view/SeatForm.fxml"));
//            BorderPane root = loader.load();
//            SeatFormController controller = loader.getController();
////            controller.setMainController(this);
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setTitle("OOPL");
//            stage.initOwner(borderPane.getScene().getWindow());
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(AdminFormController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @FXML
    private void tbScreeningClickedAction(MouseEvent event) {
        selectedScreening = tbScreening.getSelectionModel().getSelectedItem();
        if (selectedScreening != null) {
            btnBuyTicket.setDisable(false);
        }
    }

}
