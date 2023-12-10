package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Address;
import hr.java.production.model.Category;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import hr.java.production.utils.ImportCategories;
import hr.java.production.utils.ImportFactories;
import hr.java.production.utils.ImportItems;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class FactorySearchController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private TableView<Factory> tableView;
    @FXML private TableColumn<Factory, String> nameTableColumn;
    @FXML private TableColumn<Factory, Address> addressTableColumn;
    @FXML private TableColumn<Factory, List<Item>> itemsTableColumn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Factory, String>("name"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<Factory, Address>("address"));
        itemsTableColumn.setCellValueFactory(new PropertyValueFactory<Factory, List<Item>>("items"));

        tableView.getItems().setAll(ProductionApplication.factories);
    }

    @FXML
    public void search() {
        Set<Factory> filteredFactories = new HashSet<>();

        ProductionApplication.factories.forEach(factory -> {
            if (!nameTextField.getText().isEmpty() && factory.getName().toLowerCase().contains(nameTextField.getText().toLowerCase())) filteredFactories.add(factory);
        });

        if (nameTextField.getText().isEmpty()) tableView.setItems(FXCollections.observableArrayList(ProductionApplication.factories));
        else tableView.setItems(FXCollections.observableArrayList(filteredFactories));
    }
}
