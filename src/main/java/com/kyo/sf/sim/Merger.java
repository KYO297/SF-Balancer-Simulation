package com.kyo.sf.sim;

public class Merger implements Tickable {
    public final InputPort[] inputs = {new InputPort(), new InputPort(), new InputPort()};
    public final OutputPort output = new OutputPort();
    private int curr = 0;

    private boolean hasContents() {
        for (InputPort i : inputs) {
            if (i.hasContents()) {
                return true;
            }
        }
        return false;
    }

    public void tick() {
        while (output.hasRoom() && this.hasContents()) {
            if (inputs[curr].hasContents()) {
                inputs[curr].remove();
                output.add();
            }
            curr = (curr + 1) % 3;
        }
    }

    public void clear() {
        for (InputPort i : inputs) i.clear();
        output.clear();
        curr = 0;
    }
}
