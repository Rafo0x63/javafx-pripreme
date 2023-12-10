package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Category;
import hr.java.production.model.Item;
import hr.java.production.utils.ImportCategories;
import hr.java.production.utils.ImportItems;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

public class ItemSearchController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private ComboBox<Category> categoryComboBox;
    @FXML private TableView<Item> tableView;
    @FXML private TableColumn<Item, String> nameTableColumn;
    @FXML private TableColumn<Item, Category> categoryTableColumn;
    @FXML private TableColumn<Item, BigDecimal> widthTableColumn;
    @FXML private TableColumn<Item, BigDecimal> heightTableColumn;
    @FXML private TableColumn<Item, BigDecimal> lengthTableColumn;
    @FXML private TableColumn<Item, BigDecimal> productionCostTableColumn;
    @FXML private TableColumn<Item, BigDecimal> sellingPriceTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboBox.getItems().addAll(FXCollections.observableArrayList(ProductionApplication.categories));

        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        categoryTableColumn.setCellValueFactory(new PropertyValueFactory<Item, Category>("category"));
        widthTableColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("width"));
        heightTableColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("height"));
        lengthTableColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("length"));
        productionCostTableColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("productionCost"));
        sellingPriceTableColumn.setCellValueFactory(new PropertyValueFactory<Item, BigDecimal>("sellingPrice"));

        tableView.getItems().setAll(ProductionApplication.items);
    }

    @FXML
    public void search() {
        Set<Item> filteredItems = new HashSet<>();


        if (categoryComboBox.getSelectionModel().isEmpty()) {
            ProductionApplication.items.forEach(item -> {
                if (!nameTextField.getText().isEmpty() && item.getName().toLowerCase().contains(nameTextField.getText().toLowerCase())) filteredItems.add(item);
            });
        } else {
            if (nameTextField.getText().isEmpty()) {
                ProductionApplication.items.forEach(item -> {
                    if (item.getCategory().equals(categoryComboBox.getValue())) filteredItems.add(item);
                });
            } else {
                ProductionApplication.items.forEach(item -> {
                    if (item.getName().toLowerCase().contains(nameTextField.getText().toLowerCase()) && item.getCategory().equals(categoryComboBox.getValue())) filteredItems.add(item);
                });
            }
        }

        if (categoryComboBox.getSelectionModel().isEmpty() && nameTextField.getText().isEmpty()) tableView.setItems(FXCollections.observableArrayList(ProductionApplication.items));
        else tableView.setItems(FXCollections.observableArrayList(filteredItems));
    }
}
