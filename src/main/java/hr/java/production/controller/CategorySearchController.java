package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Category;
import hr.java.production.utils.ImportCategories;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.*;

public class CategorySearchController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private TableView<Category> tableView;
    @FXML private TableColumn<Category, String> nameTableColumn;
    @FXML private TableColumn<Category, String> descriptionTableColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("name"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("description"));
        tableView.getItems().setAll(ProductionApplication.categories);
    }

    @FXML
    public void search() {
        Set<Category> filteredCategories = new HashSet<>();

        ProductionApplication.categories.forEach(category -> {
            if (!nameTextField.getText().isEmpty() && category.getName().toLowerCase().contains(nameTextField.getText().toLowerCase())) filteredCategories.add(category);
        });

        if (nameTextField.getText().isEmpty()) tableView.setItems(FXCollections.observableArrayList(ProductionApplication.categories));
        else tableView.setItems(FXCollections.observableArrayList(filteredCategories));
    }
}
