package com.kyo.sf.ui.objects;

import javafx.scene.Node;

public abstract class Utils {
    public static void makeDraggable(Node node) {
        final double[] dragOffset = new double[2];
        node.setOnMousePressed(event -> {
            dragOffset[0] = event.getX();
            dragOffset[1] = event.getY();
            event.consume();
        });

        node.setOnMouseDragged(event -> {
            var parentLocal = node.getParent().sceneToLocal(event.getSceneX(), event.getSceneY());
            node.setLayoutX(parentLocal.getX() - dragOffset[0]);
            node.setLayoutY(parentLocal.getY() - dragOffset[1]);
            event.consume();
        });
    }
}
