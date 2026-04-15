package com.kyo.sf.ui.objects;

import com.kyo.sf.sim.Splitter;

public class SplitterUI extends ObjectUI {
    public Splitter splitter = new Splitter();
    public OutputUI O1;
    public OutputUI O2;
    public OutputUI O3;
    public InputUI I;

    public SplitterUI() {
        addLabel("S");

        O1 = new OutputUI(Dirs.TOP, splitter.outputs[0]);
        O2 = new OutputUI(Dirs.RIGHT, splitter.outputs[1]);
        O3 = new OutputUI(Dirs.BOTTOM, splitter.outputs[2]);
        I = new InputUI(Dirs.LEFT, splitter.input);
        getChildren().addAll(O1, O2, O3, I);
    }
}
