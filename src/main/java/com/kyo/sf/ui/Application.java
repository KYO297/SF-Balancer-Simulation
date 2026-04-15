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
        SplitterUI S1 = new SplitterUI();
        MergerUI M1 = new MergerUI();
        centerPane.getChildren().add(S1);
        centerPane.getChildren().add(M1);
        centerPane.getChildren().add(new BeltUI(S1.O2,M1.I2));

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
