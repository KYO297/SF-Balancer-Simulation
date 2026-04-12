package com.kyo.sf.sim;

public class Counter {
    private final int[] spacing = new int[Config.tracked_items];
    private int count = 0;
    private int writeIndex = 0;
    private int ticksSinceLast = 0;
    private long totalSum = 0;

    public void tick(boolean item) {
        ticksSinceLast++;
        if (item) {
            if (count == Config.tracked_items) {
                totalSum -= spacing[writeIndex];
                spacing[writeIndex] = ticksSinceLast;
                totalSum += ticksSinceLast;
            } else {
                spacing[writeIndex] = ticksSinceLast;
                totalSum += ticksSinceLast;
                count++;
            }
            writeIndex = (writeIndex + 1) % Config.tracked_items;
            ticksSinceLast = 0;
        }
    }

    public double avg() {
        if (count == 0) return 0.0;
        double avgSpacing = (double) totalSum / count;
        return Config.tick_rate / avgSpacing;
    }

    public void clear() {
        count = 0;
        writeIndex = 0;
        ticksSinceLast = 0;
        totalSum = 0;
    }

}