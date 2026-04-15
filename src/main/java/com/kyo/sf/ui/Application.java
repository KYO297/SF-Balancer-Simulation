package com.kyo.sf.ui;

import com.kyo.sf.ui.objects.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Pane centerPane = new Pane();
        root.setCenter(centerPane);

        centerPane.getChildren().add(new MergerUI());
        centerPane.getChildren().add(new SplitterUI());
        HBox controlBox = new HBox();
        controlBox.setSpacing(10);
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");

        controlBox.getChildren().addAll(startButton, stopButton);
        root.setTop(controlBox);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Balancer Simulator");
        stage.setScene(scene);
        stage.show();
    }
}
