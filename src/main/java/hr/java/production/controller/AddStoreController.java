package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Store;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;

public class AddStoreController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private TextField webAddressTextField;
    @FXML private ListView itemsListView;

    @FXML public void add() {
        if (!nameTextField.getText().isEmpty() && !webAddressTextField.getText().isEmpty() && !itemsListView.getSelectionModel().isEmpty()) {
            ProductionApplication.stores.add(new Store(new Random().nextLong(), nameTextField.getText(), webAddressTextField.getText(), new HashSet(itemsListView.getSelectionModel().getSelectedItems())));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemsListView.setItems(FXCollections.observableArrayList(ProductionApplication.items));
        itemsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
