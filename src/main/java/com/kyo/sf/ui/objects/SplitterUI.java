package com.kyo.sf.ui.objects;

public class SplitterUI extends ObjectUI {
    public SplitterUI() {
        super();
        addLabel("S");

        IODot O1 = new IODot(true, Dirs.TOP);
        IODot O2 = new IODot(true, Dirs.RIGHT);
        IODot O3 = new IODot(true, Dirs.BOTTOM);
        IODot I = new IODot(false, Dirs.LEFT);
        getChildren().addAll(O1, O2, O3, I);
    }
}
