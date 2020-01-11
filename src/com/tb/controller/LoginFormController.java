package com.tb.controller;

import com.tb.MainApp;
import com.tb.dao.UserDaoImpl;
import com.tb.entity.User;
import com.tb.util.TextUtil;
import com.tb.util.ViewUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Velz
 */
public class LoginFormController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    private UserDaoImpl userDao;
    @FXML
    private AnchorPane anchorPane;

    public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private User loginId;

    public User getLoginId() {
        return loginId;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void btnLoginAction(ActionEvent event) {
        if (!TextUtil.isEmptyField(txtUsername, txtPassword)) {
            User u = new User();
            u.setUsername(txtUsername.getText().trim());
            u.setPassword(TextUtil.SHAHash(txtPassword.getText().trim()));
            loginId = getUserDao().login(u);
            if (loginId.getId() != null) {
                if (loginId.getRole().getId().equals(1)) {
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("view/AdminForm.fxml"));
                        BorderPane root = loader.load();
                        AdminFormController controller = loader.getController();
                        controller.setMainController(this);
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("OOPL");
                        stage.initOwner(anchorPane.getScene().getWindow());
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(MainApp.class.getResource("view/UserScreenForm.fxml"));
                        BorderPane root = loader.load();
                        UserScreenFormController controller = loader.getController();
                        controller.setMainController(this);
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.setTitle("OOPL");
                        stage.initOwner(anchorPane.getScene().getWindow());
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                ViewUtil.showAlert(Alert.AlertType.ERROR, "Invalid Credentials", "Make sure to type the correct username & password");
            }
        } else {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Incomplete Field(s)", "Please fill-in all fields");
        }
    }

}
