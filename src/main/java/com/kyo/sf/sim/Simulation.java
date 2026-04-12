package com.kyo.sf.sim;

import java.util.ArrayList;

public class Simulation {
    private final ArrayList<Tickable> objects = new ArrayList<>();

    public void add(Tickable obj) {
        objects.add(obj);
    }

    public void remove(Tickable obj) {
        objects.remove(obj);
    }

    public void tick() {
        objects.forEach(Tickable::tick);
    }

    public void clear() {
        objects.forEach(Tickable::clear);
    }
}
