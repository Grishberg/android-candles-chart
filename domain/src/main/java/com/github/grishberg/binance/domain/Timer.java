package com.github.grishberg.binance.domain;

public interface Timer {
    void addTickListener(Runnable listener);

    void start();

    void stop();
}
