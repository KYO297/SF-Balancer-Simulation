package com.kyo.sf.ui;


import com.kyo.sf.sim.Belt;
import com.kyo.sf.ui.objects.IODot;
import com.kyo.sf.ui.objects.InputUI;
import com.kyo.sf.ui.objects.OutputUI;

import java.util.function.Consumer;


public class Controller {
    private IODot start = null;

    Consumer<IODot> onDragStart = (IODot start) -> {
        this.start = start;
    };

    Consumer<IODot> onDragEnd = (IODot end) -> {
        if (start != null) {
            Belt belt;
            if (start instanceof InputUI && end instanceof OutputUI) {
                belt = new Belt(1, ((OutputUI) end).outputPort, ((InputUI) start).inputPort);
            } else if (start instanceof OutputUI && end instanceof InputUI) {
                belt = new Belt(1, ((InputUI) end).inputPort, ((OutputUI) start).outputPort);
            }
            
            start = null;
        }
    };

}
