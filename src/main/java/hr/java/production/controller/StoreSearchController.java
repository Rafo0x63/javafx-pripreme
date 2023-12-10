package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Category;
import hr.java.production.model.Item;
import hr.java.production.model.Store;
import hr.java.production.utils.ImportCategories;
import hr.java.production.utils.ImportItems;
import hr.java.production.utils.ImportStores;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class StoreSearchController implements Initializable {
    @FXML TextField nameTextField;
    @FXML TableView<Store> tableView;
    @FXML TableColumn<Store, String> nameTableColumn;
    @FXML TableColumn<Store, String> webAddressTableColumn;
    @FXML TableColumn<Store, List<Item>> itemsTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Store, String>("name"));
        webAddressTableColumn.setCellValueFactory(new PropertyValueFactory<Store, String>("webAddress"));
        itemsTableColumn.setCellValueFactory(new PropertyValueFactory<Store, List<Item>>("items"));

        tableView.getItems().setAll(ProductionApplication.stores);
    }

    @FXML
    public void search() {
        Set<Store> filteredStores = new HashSet<>();

        ProductionApplication.stores.forEach(store -> {
            if (!nameTextField.getText().isEmpty() && store.getName().toLowerCase().contains(nameTextField.getText().toLowerCase())) filteredStores.add(store);
        });

        if (nameTextField.getText().isEmpty()) tableView.setItems(FXCollections.observableArrayList(ProductionApplication.stores));
        else tableView.setItems(FXCollections.observableArrayList(filteredStores));
    }
}
