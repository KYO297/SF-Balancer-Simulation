package com.kyo.sf.sim;

public abstract class Buffer {
    private int contents = 0;

    public boolean isFull() {
        return contents >= Config.buffer_capacity;
    }

    public boolean hasRoom() {
        return contents < Config.buffer_capacity;
    }

    public boolean isEmpty() {
        return contents <= 0;
    }

    public boolean hasContents() {
        return contents > 0;
    }

    public void add() {
        if (isFull()) {
            throw new FullBufferException("Attempted to add to full buffer");
        } else {
            contents++;
        }
    }

    public void remove() {
        if (isEmpty()) {
            throw new EmptyBufferException("Attempted to remove from empty buffer");
        } else {
            contents--;
        }
    }

    public void clear() {
        contents = 0;
    }
}
