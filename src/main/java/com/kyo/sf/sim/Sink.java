package com.kyo.sf.sim;

public class Sink implements Tickable {
    public final InputPort input = new InputPort();
    private double speed;
    private final RateLimiter limiter;

    public Sink(double speed) {
        limiter = new RateLimiter();
        setSpeed(speed);
    }

    public void setSpeed(double speed) {
        limiter.setSpeed(speed);
        this.speed = speed;
    }

    public void tick() {
        if (limiter.tick() && input.hasContents()) {
            input.remove();
            limiter.success();
        }
    }

    public void clear() {
        input.clear();
        limiter.reset();
    }

    public double getSpeed() {
        return speed;
    }
}
