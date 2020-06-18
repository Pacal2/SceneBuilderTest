package sample;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
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

    //RadioButton example
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton phpRadioButton;
    @FXML private RadioButton cSharpRadioButton;
    @FXML private RadioButton cPlusPlusRadioButton;
    @FXML private Label radioButtonLabel;
    private ToggleGroup favLangToggleGroup;

    //ListView example
    @FXML private ListView listView;
    @FXML private TextArea gamesTextArea;

    //Scene Changer
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TableViewExample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //Get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

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

    public void radioButtonChanged() {
        String text = "The selected item is: ";
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton)) {
            radioButtonLabel.setText(text + "PHP");
        }
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton)) {
            radioButtonLabel.setText(text + "Java");
        }
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.cPlusPlusRadioButton)) {
            radioButtonLabel.setText(text + "C++");
        }
        if (this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton)) {
            radioButtonLabel.setText(text + "C#");
        }

    }

    public void listViewButtonPushed(){
        String textAreaString = "";

        ObservableList listOfGames = listView.getSelectionModel().getSelectedItems();

        for (Object item : listOfGames) {
            textAreaString  += String.format("%s%n", (String) item);
        }

        this.gamesTextArea.setText(textAreaString);
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaOrderLabel.setText("");

        //ChoiceBox
        choiceBoxLabel.setText("");
        choiceBox.getItems().addAll("apples", "bananas", "oranges", "pears", "peaches");

        //ComboBox
        comboBox.getItems().addAll("The Maxx", "Dorohedoro", "Incal", "Blame", "Nausicaa", "Oyasumi Punpun", "Incal");
        comboBoxLabel.setText("");

        //RadioButton
        radioButtonLabel.setText("");
        this.favLangToggleGroup = new ToggleGroup();
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);
        this.cPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);

        //ListView
        listView.getItems().addAll("Planescape: Torment", "Morrowind", "Bloodborne", "Nier: Automata", "Hollow Knight");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
