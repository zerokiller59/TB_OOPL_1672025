package com.tb.util;

import javafx.scene.control.Alert;

/**
 *
 * @author Velz
 */
public class ViewUtil {

    private static Alert alert;

    static {
        alert = new Alert(Alert.AlertType.NONE);
    }

    public static void showAlert(Alert.AlertType type, String content) {
        showAlert(type, null, content);
    }

    public static void showAlert(Alert.AlertType type, String title, String content) {
        alert.setAlertType(type);
        alert.setContentText(content);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
