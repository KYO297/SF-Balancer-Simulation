package com.kyo.sf.ui;


import com.kyo.sf.sim.Belt;
import com.kyo.sf.sim.Simulation;
import com.kyo.sf.ui.objects.BeltUI;
import com.kyo.sf.ui.objects.IODot;
import com.kyo.sf.ui.objects.InputUI;
import com.kyo.sf.ui.objects.OutputUI;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.function.Consumer;


public class Controller {
    private IODot start = null;
    private final Simulation sim = new Simulation();
    BorderPane root = new BorderPane();
    Pane centerPane = new Pane();

    Consumer<IODot> onDragStart = (IODot start) -> this.start = start;

    Consumer<IODot> onDragEnd = (IODot end) -> {
        if (start != null) {
            Belt belt = null;
            if (start instanceof InputUI && end instanceof OutputUI) {
                belt = new Belt(1, ((OutputUI) end).outputPort, ((InputUI) start).inputPort);
            } else if (start instanceof OutputUI && end instanceof InputUI) {
                belt = new Belt(1, ((InputUI) end).inputPort, ((OutputUI) start).outputPort);
            }
            if (belt != null) {
                sim.add(belt);
                BeltUI beltLine = new BeltUI(start, end);
                centerPane.getChildren().add(beltLine);
            }
            start = null;
        }
    };

    public void setup() {
        root.setCenter(centerPane);
    }

    private IODot dragStart = null;
    private Line previewLine = null;

    // Call this when setting up each IODot
    public void wireDot(IODot dot) {
        dot.setOnMousePressed(event -> {
            dragStart = dot;

            // Create the preview line, binding one end to the dot
            previewLine = new Line();
            previewLine.setStroke(Color.GRAY);
            previewLine.getStrokeDashArray().addAll(8.0, 4.0); // dashed line looks good for preview

            previewLine.startXProperty().bind(dot.getParent().layoutXProperty().add(dot.centerXProperty()));
            previewLine.startYProperty().bind(dot.getParent().layoutYProperty().add(dot.centerYProperty()));

            // End starts at the same position
            previewLine.setEndX(event.getSceneX());
            previewLine.setEndY(event.getSceneY());

            canvas.getChildren().add(previewLine);
            event.consume();
        });

        dot.setOnMouseDragged(event -> {
            if (previewLine != null) {
                // Convert scene coords to canvas coords (same pattern as object dragging)
                var canvasLocal = canvas.sceneToLocal(event.getSceneX(), event.getSceneY());
                previewLine.setEndX(canvasLocal.getX());
                previewLine.setEndY(canvasLocal.getY());
            }
            event.consume();
        });

        dot.setOnMouseReleased(event -> {
            // Remove preview regardless of whether connection succeeded
            if (previewLine != null) {
                canvas.getChildren().remove(previewLine);
                previewLine = null;
            }
            dragStart = null;
            event.consume();
        });
    }
}
