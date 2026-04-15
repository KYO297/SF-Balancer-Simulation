package com.kyo.sf.ui.objects;

import com.kyo.sf.ui.UIConfig;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ObjectUI extends Pane {
    public ObjectUI() {
        Rectangle shape = new Rectangle(UIConfig.SHAPE_SIZE, UIConfig.SHAPE_SIZE);
        shape.setFill(Color.WHITE);
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(UIConfig.SHAPE_SIZE / 32);
        getChildren().add(shape);
        Utils.makeDraggable(this);
    }

    protected void addLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Sans", FontWeight.BOLD, UIConfig.SHAPE_SIZE / 4));

        Platform.runLater(() -> {
            label.setLayoutX(getLayoutX() + UIConfig.SHAPE_SIZE / 2 - label.getWidth() / 2);
            label.setLayoutY(getLayoutY() + UIConfig.SHAPE_SIZE / 2 - label.getHeight() / 2);
        });

        getChildren().add(label);
    }

}
