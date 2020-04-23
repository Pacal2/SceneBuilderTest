package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    //CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox baconCheckBox;

    //ChoiceBox example
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    //ComboBox example
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;

    public void choiceBoxButtonPushed() {
        choiceBoxLabel.setText(choiceBox.getValue().toString());
    }

    public void pizzaOrderButtonPushed() {
        String order = "Toppings are: ";
        if (pepperoniCheckBox.isSelected()) {
            order += "\npepperoni";
        }
        if (pineappleCheckBox.isSelected()) {
            order += "\npineapple";
        }
        if (baconCheckBox.isSelected()) {
            order += "\nbacon";
        }
        this.pizzaOrderLabel.setText(order);
    }

    public void comboBoxWasUpdated() {
        this.comboBoxLabel.setText("Comic selected: \n" + comboBox.getValue().toString());
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaOrderLabel.setText("");

        //ChoiceBox
        choiceBoxLabel.setText("");
        choiceBox.getItems().addAll("apples", "bananas", "oranges", "pears");

        //ComboBox
        comboBox.getItems().addAll("The Maxx", "Dorohedoro", "Incal", "Blame", "Nausicaa");
    }
}
