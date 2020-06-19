package sample;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class TableViewExampleController implements Initializable {


    // Table configuration
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;

    public void editFirstNameCellEvent(TableColumn.CellEditEvent editedCell) {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(editedCell.getNewValue().toString());

    }

    public void editLastNameCellEvent(TableColumn.CellEditEvent editedCell) {
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(editedCell.getNewValue().toString());

    }

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //Get stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Column set up
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        // Data loading
        tableView.setItems(getPeople());

        // Editable tables
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


    }

    public ObservableList<Person> getPeople()
    {
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new Person("Rebecca", "Fergusson", LocalDate.of(1986, Month.JULY, 21)));
        people.add(new Person("Mr", "T.", LocalDate.of(1952, Month.DECEMBER, 12)));


        return people;
    }
}
