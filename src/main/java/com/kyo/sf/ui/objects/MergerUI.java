package com.kyo.sf.ui.objects;


import com.kyo.sf.sim.Merger;

public class MergerUI extends ObjectUI {
    public Merger merger = new Merger();

    public MergerUI() {
        addLabel("M");

        InputUI I1 = new InputUI(Dirs.TOP, merger.inputs[0]);
        InputUI I2 = new InputUI(Dirs.LEFT, merger.inputs[1]);
        InputUI I3 = new InputUI(Dirs.BOTTOM, merger.inputs[2]);
        OutputUI O = new OutputUI(Dirs.RIGHT, merger.output);
        getChildren().addAll(I1, I2, I3, O);
    }
}
