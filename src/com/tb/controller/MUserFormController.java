package com.tb.controller;

import com.tb.MainApp;
import com.tb.dao.BalanceDaoImpl;
import com.tb.dao.UserDaoImpl;
import com.tb.entity.BalanceHistory;
import com.tb.entity.Role;
import com.tb.entity.User;
import com.tb.util.TextUtil;
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
public class MUserFormController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnTopUp;
    @FXML
    private Button btnViewHistory;
    @FXML
    private TextField txtBalance;
    @FXML
    private TableView<User> tbUser;
    @FXML
    private TableColumn<User, String> colUser;
    @FXML
    private TableColumn<User, String> colBalance;

    private AdminFormController mainController;
    @FXML
    private TextField txtName;
    @FXML
    private BorderPane borderPane;

    public void setMainController(AdminFormController mainController) {
        this.mainController = mainController;
    }

    private ObservableList<User> users;

    public ObservableList<User> getUsers() {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().showAllData());
        }
        return users;
    }

    private UserDaoImpl userDao;

    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private BalanceDaoImpl balanceDao;

    public BalanceDaoImpl getBalanceDao() {
        if (balanceDao == null) {
            balanceDao = new BalanceDaoImpl();
        }
        return balanceDao;
    }

    private User selectedUser;

    public User getSelectedUser() {
        return selectedUser;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tbUser.setItems(getUsers());
        colUser.setCellValueFactory(d -> {
            return new SimpleStringProperty(d.getValue().getUsername());
        });
        colBalance.setCellValueFactory(d -> {
            double balance = getBalanceDao().countUserBalance(d.getValue());
            return new SimpleStringProperty(String.valueOf(balance));
        });
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        if (selectedUser == null) {
            User u = new User();
            u.setUsername(txtUsername.getText().trim());
            u.setPassword(TextUtil.SHAHash(txtPassword.getText().trim()));
            Role r = new Role();
            r.setId(2);
            u.setRole(r);
            u.setName(txtName.getText().trim());
            if (getUserDao().addData(u) != 1) {
                ViewUtil.showAlert(Alert.AlertType.ERROR, "Something went wrong (add user)");
            } else {
                txtPassword.clear();
            }
        } else {
            selectedUser.setUsername(txtUsername.getText().trim());
            selectedUser.setPassword(TextUtil.SHAHash(txtPassword.getText().trim()));
            selectedUser.setName(txtName.getText().trim());
            if (getUserDao().updateData(selectedUser) != 1) {
                ViewUtil.showAlert(Alert.AlertType.ERROR, "Something went wrong (update user)");
            } else {
                txtPassword.clear();
            }
        }
        users.clear();
        users.addAll(getUserDao().showAllData());
    }

    @FXML
    private void btnResetAction(ActionEvent event) {
        selectedUser = null;
        txtBalance.setDisable(true);
        btnTopUp.setDisable(true);
        btnViewHistory.setDisable(true);
        txtBalance.clear();
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    private void btnTopUpAction(ActionEvent event) {
        BalanceHistory topup = new BalanceHistory();
        topup.setUser(selectedUser);
        topup.setIsTopup(true);
        topup.setValue(Double.valueOf(txtBalance.getText().trim()));
        topup.setDescription(new Date().toString());
        if (getBalanceDao().addData(topup) != 1) {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Something went wrong (top up)");
        }
        tbUser.refresh();
    }

    @FXML
    private void btnViewHistoryAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TransactionHistoryForm.fxml"));
            BorderPane root = loader.load();
            TransactionHistoryFormController controller = loader.getController();
            controller.setUserParam(getSelectedUser());
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
    private void tbUserClickedAction(MouseEvent event) {
        selectedUser = tbUser.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            if (selectedUser.getRole().getId() != mainController.getLoginId().getRole().getId()) {
                txtBalance.setDisable(false);
                btnTopUp.setDisable(false);
                btnViewHistory.setDisable(false);
            } else {
                txtBalance.setDisable(true);
                btnTopUp.setDisable(true);
                btnViewHistory.setDisable(true);
                txtBalance.clear();
            }
            txtName.setText(selectedUser.getName());
            txtUsername.setText(selectedUser.getUsername());
        }
        txtPassword.clear();
    }

}
