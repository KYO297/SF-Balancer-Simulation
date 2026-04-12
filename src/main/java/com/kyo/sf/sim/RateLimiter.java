package com.kyo.sf.sim;

class RateLimiter {
    private double delay;
    private double progress = 0;
    private boolean ready = false;

    public void setSpeed(double speed) {
        this.delay = speed > 0 ? (double) Config.tick_rate / speed : Double.POSITIVE_INFINITY;
    }

    boolean tick() {
        if (!ready) {
            if (++progress >= delay) {
                ready = true;
            }
        }
        return ready;
    }

    public void reset() {
        ready = false;
        progress = 0;
    }

    public void success() {
        progress -= delay;
        ready = false;
    }
}
