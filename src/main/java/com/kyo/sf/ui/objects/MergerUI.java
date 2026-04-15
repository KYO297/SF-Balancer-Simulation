package com.kyo.sf.ui.objects;


import com.kyo.sf.sim.Merger;

public class MergerUI extends ObjectUI {
    public Merger merger = new Merger();
    public InputUI I1;
    public InputUI I2;
    public InputUI I3;
    public OutputUI O;

    public MergerUI() {
        addLabel("M");
        I1 = new InputUI(Dirs.TOP, merger.inputs[0]);
        I2 = new InputUI(Dirs.LEFT, merger.inputs[1]);
        I3 = new InputUI(Dirs.BOTTOM, merger.inputs[2]);
        O = new OutputUI(Dirs.RIGHT, merger.output);
        getChildren().addAll(I1, I2, I3, O);
    }
}
