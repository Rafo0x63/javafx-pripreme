module hr.java.production {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires org.slf4j;


    opens hr.java.production to javafx.fxml;
    exports hr.java.production;
    exports hr.java.production.controller;
    exports hr.java.production.model;
    opens hr.java.production.controller to javafx.fxml;
    opens hr.java.production.model to javafx.fxml;

}