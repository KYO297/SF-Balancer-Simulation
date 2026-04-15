package com.kyo.sf.ui.objects;


import javafx.scene.shape.Line;

public class BeltUI extends Line {
    public BeltUI(IODot start, IODot end) {
        startXProperty().bind(start.layoutXProperty());
        startYProperty().bind(start.layoutYProperty());
        endXProperty().bind(end.layoutXProperty());
        endYProperty().bind(end.layoutYProperty());
    }
}
