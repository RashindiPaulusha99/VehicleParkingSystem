package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginPopupFormController {
    public AnchorPane logInFormContext;
    public Label errorMassageContext;
    public JFXPasswordField passwordContext;
    public JFXButton button;
    public JFXButton btnCancel;
    public JFXTextField userNameContext;
    public Label errorMassageContext1;

    public void openParkingSystemForm(ActionEvent actionEvent) throws IOException {

        /*Check correct password and user name*/
        button.setOnAction(e -> {
            String pwd = passwordContext.getText();
            String uname = userNameContext.getText();
            if(pwd.equals("9926rp")&&uname.equals("Admin")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ParkingDeliveryDetailsForm.fxml"));
                Parent parent = null;
                try {
                    parent = loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                    ParkingDeliveryDetailsFormController controller = loader.<ParkingDeliveryDetailsFormController>getController();
                    Scene scene = new Scene(parent);
                    Stage window = (Stage) logInFormContext.getScene().getWindow();
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    window.close();
            }else if(pwd.equals("")&&uname.equals("")){
                errorMassageContext1.setText("Please enter user name. ");
                errorMassageContext.setText("Please enter password. ");
            } else {
                errorMassageContext.setText("Entry user name or password invalid . Try again!");
            }
        });
    }

    public void cancelLogInForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SelectVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) logInFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
