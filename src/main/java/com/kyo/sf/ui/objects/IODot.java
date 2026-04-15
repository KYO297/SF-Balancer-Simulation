package com.kyo.sf.ui.objects;


import com.kyo.sf.ui.UIConfig;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class IODot extends Circle {
    private double cx;
    private double cy;

    public IODot(boolean filled, Dirs dir) {
        setRadius(UIConfig.SHAPE_SIZE / 10);
        setFill(filled ? Color.BLACK : Color.WHITE);
        setStroke(Color.BLACK);
        setStrokeWidth(UIConfig.SHAPE_SIZE / 32);
        Platform.runLater(() -> {
            final double x = getParent().getLayoutX();
            final double y = getParent().getLayoutY();
            this.cx = x + UIConfig.SHAPE_SIZE / 2;
            this.cy = y + UIConfig.SHAPE_SIZE / 2;
            setLocation(dir);
        });

    }

    private void setLocation(Dirs dir) {
        switch (dir) {
            case Dirs.TOP:
                setCenterX(cx);
                setCenterY(cy + UIConfig.SHAPE_SIZE / 2);
                break;
            case Dirs.BOTTOM:
                setCenterX(cx);
                setCenterY(cy - UIConfig.SHAPE_SIZE / 2);
                break;
            case Dirs.RIGHT:
                setCenterX(cx + UIConfig.SHAPE_SIZE / 2);
                setCenterY(cy);
                break;
            case Dirs.LEFT:
                setCenterX(cx - UIConfig.SHAPE_SIZE / 2);
                setCenterY(cy);
                break;
        }
    }
}
