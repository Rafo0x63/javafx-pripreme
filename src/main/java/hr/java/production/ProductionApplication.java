package hr.java.production;

import hr.java.production.model.Category;
import hr.java.production.model.Factory;
import hr.java.production.model.Item;
import hr.java.production.model.Store;
import hr.java.production.utils.ImportCategories;
import hr.java.production.utils.ImportFactories;
import hr.java.production.utils.ImportItems;
import hr.java.production.utils.ImportStores;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProductionApplication extends Application {

    public static Stage mainStage;
    public static List<Category> categories;
    public static List<Item> items;
    public static List<Factory> factories;
    public static List<Store> stores;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        categories = ImportCategories.importCategories();
        items = ImportItems.importItems(categories);
        factories = ImportFactories.inputFactories(items);
        stores = ImportStores.inputStores(items);

        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Production app");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}