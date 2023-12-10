package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddCategoryController {
    @FXML private TextField nameTextField;
    @FXML private TextField descriptionTextField;

    @FXML
    public void add() {
        if (!nameTextField.getText().isEmpty() && !descriptionTextField.getText().isEmpty()) ProductionApplication.categories.add(new Category(nameTextField.getText(), descriptionTextField.getText()));
    }
}
