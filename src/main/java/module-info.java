module com.kyo.sf {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    opens com.kyo.sf.ui to javafx.fxml;
    opens com.kyo.sf.sim to javafx.fxml;
    exports com.kyo.sf.ui;
    exports com.kyo.sf.sim;

}