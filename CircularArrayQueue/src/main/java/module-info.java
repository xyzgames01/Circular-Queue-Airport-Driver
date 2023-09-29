module com.airport.circulararrayqueue {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.airport.circulararrayqueue to javafx.fxml;
    exports com.airport.circulararrayqueue;
}