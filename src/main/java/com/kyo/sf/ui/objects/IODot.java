package com.kyo.sf.ui.objects;


import com.kyo.sf.ui.UIConfig;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class IODot extends Circle {

    public IODot(boolean filled, Dirs dir) {
        setRadius(UIConfig.SHAPE_SIZE / 10);
        setFill(filled ? Color.BLACK : Color.WHITE);
        setStroke(Color.BLACK);
        setStrokeWidth(UIConfig.SHAPE_SIZE / 32);
        setLocation(dir);
        setOnDragDetected(event -> {
        });
        setOnDragDone(event -> {
        });
    }

    private void setLocation(Dirs dir) {
        final double half = UIConfig.SHAPE_SIZE / 2;
        switch (dir) {
            case TOP -> {
                setCenterX(half);
                setCenterY(0);
            }
            case BOTTOM -> {
                setCenterX(half);
                setCenterY(UIConfig.SHAPE_SIZE);
            }
            case LEFT -> {
                setCenterX(0);
                setCenterY(half);
            }
            case RIGHT -> {
                setCenterX(UIConfig.SHAPE_SIZE);
                setCenterY(half);
            }
        }
    }
}
