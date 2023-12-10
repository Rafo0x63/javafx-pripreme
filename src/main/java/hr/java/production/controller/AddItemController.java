package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import hr.java.production.model.Category;
import hr.java.production.model.Discount;
import hr.java.production.model.Item;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;

public class AddItemController implements Initializable {
    @FXML private TextField nameTextField;
    @FXML private ComboBox categoryComboBox;
    @FXML private TextField widthTextField;
    @FXML private TextField heightTextField;
    @FXML private TextField lengthTextField;
    @FXML private TextField productionCostTextField;
    @FXML private TextField sellingPriceTextField;
    @FXML private TextField discountTextField;

    @FXML
    public void add() {
        if (!nameTextField.getText().isEmpty() &&
            !categoryComboBox.getSelectionModel().isEmpty() &&
            !widthTextField.getText().isEmpty() &&
            !heightTextField.getText().isEmpty() &&
            !lengthTextField.getText().isEmpty() &&
            !productionCostTextField.getText().isEmpty() &&
            !sellingPriceTextField.getText().isEmpty() &&
            !discountTextField.getText().isEmpty()) {
            ProductionApplication.items.add(new Item(new Random().nextLong(),
                                                        nameTextField.getText(),
                                                        (Category) categoryComboBox.getValue(),
                                                        new BigDecimal(widthTextField.getText()),
                                                        new BigDecimal(heightTextField.getText()),
                                                        new BigDecimal(lengthTextField.getText()),
                                                        new BigDecimal(productionCostTextField.getText()),
                                                        new BigDecimal(sellingPriceTextField.getText()),
                                                        new Discount(new BigDecimal(discountTextField.getText()))));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboBox.setItems(FXCollections.observableArrayList(ProductionApplication.categories));
    }
}
