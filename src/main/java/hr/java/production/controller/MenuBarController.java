package hr.java.production.controller;

import hr.java.production.ProductionApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuBarController {

    @FXML
    public void searchCategories() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("category-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }

    @FXML
    public void searchItems() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("item-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }
    @FXML
    public void searchFactories() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("factory-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }
    @FXML
    public void searchStores() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("store-search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }

    @FXML
    public void addCategory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("add-category-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }

    @FXML
    public void addItem() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("add-item-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }

    @FXML
    public void addFactory() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("add-factory-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }

    @FXML
    public void addStore() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductionApplication.class.getResource("add-store-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ProductionApplication.mainStage.setScene(scene);
        ProductionApplication.mainStage.show();
    }
}
