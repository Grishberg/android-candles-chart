package com.github.grishberg.binance.domain;

public interface Candle {
    float hight();
    float low();
    float open();
    float closed();
    long timestamp();
}
