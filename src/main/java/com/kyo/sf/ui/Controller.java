package com.kyo.sf.ui;


import com.kyo.sf.sim.*;
import com.kyo.sf.ui.objects.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

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
                BeltUI beltLine = new BeltUI(start,end);
                centerPane.getChildren().add(beltLine);
            }
            start = null;
        }
    };

    public void setup(){
        root.setCenter(centerPane);
    }

}
