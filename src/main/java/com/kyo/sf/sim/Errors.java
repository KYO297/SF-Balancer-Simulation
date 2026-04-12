package com.kyo.sf.sim;

class FullBufferException extends RuntimeException {
    public FullBufferException(String message) {
        super(message);
    }
}

class EmptyBufferException extends RuntimeException  {
    public EmptyBufferException(String message) {
        super(message);
    }
}
