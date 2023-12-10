package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.enums.Cities;
import hr.java.production.model.Address;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class AddFactoryController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private TextField streetTextField;
    @FXML private TextField streetNumberTextField;
    @FXML private ComboBox cityComboBox;
    @FXML private ListView itemsListView;

    @FXML
    public void add() {
        if (!nameTextField.getText().isEmpty() && !streetNumberTextField.getText().isEmpty() && !cityComboBox.getSelectionModel().isEmpty() && !itemsListView.getSelectionModel().isEmpty()) {
            Address address = new Address(streetTextField.getText(), streetNumberTextField.getText(), (Cities) cityComboBox.getValue());
            ProductionApplication.factories
                    .add(new Factory(new Random().nextLong(), nameTextField.getText(),address, new HashSet<>(itemsListView.getSelectionModel().getSelectedItems())));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Cities> cities = new ArrayList<>();
        Collections.addAll(cities, Cities.values());

        cityComboBox.setItems(FXCollections.observableArrayList(cities));
        itemsListView.setItems(FXCollections.observableArrayList(ProductionApplication.items));
        itemsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
