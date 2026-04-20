package com.kyo.sf.ui.objects;

import com.kyo.sf.ui.UIConfig;
import javafx.scene.shape.Line;

public class BeltUI extends Line {
    public BeltUI(IODot start, IODot end) {
        startXProperty().bind(start.getParent().layoutXProperty().add(start.centerXProperty()));
        startYProperty().bind(start.getParent().layoutYProperty().add(start.centerYProperty()));
        endXProperty().bind(end.getParent().layoutXProperty().add(end.centerXProperty()));
        endYProperty().bind(end.getParent().layoutYProperty().add(end.centerYProperty()));
        setStrokeWidth(UIConfig.SHAPE_SIZE / 32);
    }
}
