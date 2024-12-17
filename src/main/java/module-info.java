module org.example.trspolaba4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.jakartaee.web.api;
    requires spring.data.jpa;
    requires java.sql;



    opens org.example.trspolaba4 to javafx.fxml;
    exports org.example.trspolaba4;

}