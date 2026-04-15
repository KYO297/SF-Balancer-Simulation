package com.kyo.sf.ui.objects;

import com.kyo.sf.sim.InputPort;

public class InputUI extends IODot {
    public InputPort inputPort;

    public InputUI(Dirs dir, InputPort port) {
        super(false, dir);
        inputPort = port;
    }
}
