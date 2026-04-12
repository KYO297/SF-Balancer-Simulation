package com.kyo.sf.sim;

public class Source implements Tickable {
    public final OutputPort output = new OutputPort();
    private double speed;
    private final RateLimiter limiter;

    public Source(double speed) {
        limiter = new RateLimiter();
        setSpeed(speed);
    }

    public void setSpeed(double speed) {
        limiter.setSpeed(speed);
        this.speed = speed;
    }

    public void tick() {
        if (limiter.tick() && output.hasRoom()) {
            output.add();
            limiter.success();
        }
    }

    public void clear() {
        output.clear();
        limiter.reset();
    }

    public double getSpeed() {
        return speed;
    }
}
