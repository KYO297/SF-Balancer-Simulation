package com.kyo.sf.sim;

import java.util.HashMap;

public abstract class Config {
    public static final int buffer_capacity = 3;
    public static final int tick_rate = 8775;
    public static final int tracked_items = 1200;
    private static final HashMap<Integer, Integer> belt_speeds;

    static {
        belt_speeds = new HashMap<>();
        belt_speeds.put(1, 60);
        belt_speeds.put(2, 120);
        belt_speeds.put(3, 270);
        belt_speeds.put(4, 480);
        belt_speeds.put(5, 780);
        belt_speeds.put(6, 1200);
    }

    public static int getBeltSpeed(int tier) {
        return belt_speeds.get(tier);
    }
}
