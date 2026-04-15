package com.kyo.sf.ui.objects;

import com.kyo.sf.sim.OutputPort;

public class OutputUI extends IODot {
    public OutputPort outputPort;

    public OutputUI(Dirs dir, OutputPort port) {
        super(true, dir);
        outputPort = port;
    }
}
