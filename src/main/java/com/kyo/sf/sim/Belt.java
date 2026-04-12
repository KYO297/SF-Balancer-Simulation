package com.kyo.sf.sim;

public class Belt implements Tickable {
    private final OutputPort from;
    private final InputPort to;
    private int tier;
    private final Counter counter = new Counter();
    private final RateLimiter limiter;

    public Belt(int tier, OutputPort from, InputPort to) {
        limiter = new RateLimiter();
        setTier(tier);
        this.from = from;
        this.to = to;
    }

    public Belt(int tier, InputPort to, OutputPort from) {
        this(tier, from, to);
    }

    public void setTier(int tier) {
        if (tier < 1 || tier > 6) throw new IllegalArgumentException("Belt tier must be between 1 and 6");
        limiter.setSpeed(Config.getBeltSpeed(tier));
        this.tier = tier;
    }

    public void tick() {
        if (limiter.tick() && from.hasContents() && to.hasRoom()) {
            from.remove();
            to.add();
            counter.tick(true);
            limiter.success();
        } else {
            counter.tick(false);
        }
    }

    public double avg() {
        return counter.avg();
    }

    public void clear() {
        counter.clear();
        limiter.reset();
    }

    public int getTier() {
        return tier;
    }
}
