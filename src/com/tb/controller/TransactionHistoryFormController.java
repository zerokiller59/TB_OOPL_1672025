package com.tb.controller;

import com.tb.dao.BalanceDaoImpl;
import com.tb.entity.BalanceHistory;
import com.tb.entity.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class TransactionHistoryFormController implements Initializable {

    @FXML
    private Label labelTicketId;
    @FXML
    private Label labelMovie;
    @FXML
    private Label labelSeatPurchased;
    @FXML
    private Label labelStudio;
    @FXML
    private Label labelStartAt;
    @FXML
    private TableView<BalanceHistory> tbTransaction;
    @FXML
    private TableColumn<BalanceHistory, String> colType;
    @FXML
    private TableColumn<BalanceHistory, String> colValue;
    @FXML
    private TableColumn<BalanceHistory, String> colTime;

    private BalanceDaoImpl balanceDao;

    public BalanceDaoImpl getBalanceDao() {
        if (balanceDao == null) {
            balanceDao = new BalanceDaoImpl();
        }
        return balanceDao;
    }

    private ObservableList<BalanceHistory> balanceHistory;

    public ObservableList<BalanceHistory> getBalanceHistory() {
        if (balanceHistory == null) {
            balanceHistory = FXCollections.observableArrayList();
        }
        return balanceHistory;
    }

    private User userParam;

    public User getUserParam() {
        return userParam;
    }

    public void setUserParam(User userParam) {
        this.userParam = userParam;
        getBalanceHistory().addAll(getBalanceDao().showTransactionBy(userParam));
        tbTransaction.setItems(getBalanceHistory());
    }

    private BalanceHistory selectedHistory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colType.setCellValueFactory(d -> {
            if (d.getValue().isIsTopup()) {
                return new SimpleStringProperty("Top up");
            } else {
                return new SimpleStringProperty("Buying Ticket");
            }
        });
        colValue.setCellValueFactory(d -> {
            return new SimpleStringProperty(String.valueOf(d.getValue().getValue()));
        });
        colTime.setCellValueFactory(d -> {
            if (d.getValue().getDescription() != null) {
                int descIndex = d.getValue().getDescription().indexOf("|");
                int descLength = d.getValue().getDescription().length();
                String timeDesc = d.getValue().getDescription().substring(0, descIndex);
                String ticketId = d.getValue().getDescription().substring(descIndex + 1, descLength);
                return new SimpleStringProperty(timeDesc);
            } else {
                return new SimpleStringProperty(String.valueOf(d.getValue().getDescription()));
            }
        });
    }

    @FXML
    private void tbTransactionClickedAction(MouseEvent event) {
        selectedHistory = tbTransaction.getSelectionModel().getSelectedItem();
        if (selectedHistory != null) {
            if (!selectedHistory.isIsTopup()) {
                int descIndex = selectedHistory.getDescription().indexOf("|");
                int descLength = selectedHistory.getDescription().length();
                String ticketId = selectedHistory.getDescription().substring(descIndex + 1, descLength);
                labelTicketId.setText(ticketId);
//                labelMovie.setText(value);
//                labelStudio.setText(value);
//                labelStartAt.setText(value);
            } else {
                labelTicketId.setText("-");
                labelMovie.setText("-");
                labelStudio.setText("-");
                labelStartAt.setText("-");
            }
        }
    }

    @FXML
    private void btnPrintTicketAction(ActionEvent event) {
    }

}
