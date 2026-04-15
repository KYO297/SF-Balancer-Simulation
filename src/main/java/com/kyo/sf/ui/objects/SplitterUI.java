package com.kyo.sf.ui.objects;

import com.kyo.sf.sim.Splitter;

public class SplitterUI extends ObjectUI {
    public Splitter splitter = new Splitter();

    public SplitterUI() {
        addLabel("S");

        OutputUI O1 = new OutputUI(Dirs.TOP, splitter.outputs[0]);
        OutputUI O2 = new OutputUI(Dirs.RIGHT, splitter.outputs[1]);
        OutputUI O3 = new OutputUI(Dirs.BOTTOM, splitter.outputs[2]);
        InputUI I = new InputUI(Dirs.LEFT, splitter.input);
        getChildren().addAll(O1, O2, O3, I);
    }
}
