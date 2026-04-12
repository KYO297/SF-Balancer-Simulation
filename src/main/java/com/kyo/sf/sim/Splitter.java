package com.kyo.sf.sim;

public class Splitter implements Tickable {
    public final InputPort input = new InputPort();
    public final OutputPort[] outputs = {new OutputPort(), new OutputPort(), new OutputPort()};
    private int curr = 0;

    private boolean hasRoom() {
        for (OutputPort o : outputs) {
            if (o.hasRoom()) {
                return true;
            }
        }
        return false;
    }

    public void tick() {
        while (input.hasContents() && this.hasRoom()) {
            if (outputs[curr].hasRoom()) {
                input.remove();
                outputs[curr].add();
            }
            curr = (curr + 1) % 3;
        }
    }

    public void clear() {
        for (OutputPort o : outputs) o.clear();
        input.clear();
        curr = 0;
    }
}
