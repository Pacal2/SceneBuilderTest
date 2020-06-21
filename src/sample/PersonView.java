package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PersonView implements Initializable {

    private Person selectedPerson;

    @FXML private Label firstNameLabel;
    @FXML private Label lastNameLabel;
    @FXML private Label birthdayLabel;
    @FXML private Label ageLabel;
    @FXML private ImageView photo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // accepts person to initialize the view
    public void initData(Person person) {
            selectedPerson = person;
            firstNameLabel.setText(selectedPerson.getFirstName());
            lastNameLabel.setText(selectedPerson.getLastName());
            birthdayLabel.setText(selectedPerson.getBirthday().toString());
            photo.setImage(selectedPerson.getPhoto());
            ageLabel.setText(Integer.toString(selectedPerson.getAge()));
    }

    public void backButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableViewExample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //Get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
