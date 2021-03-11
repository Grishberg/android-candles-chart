package com.github.grishberg.candles;

import com.github.grishberg.binance.domain.Candle;

public class CandleImpl implements Candle {
    private final float hight;
    private final float low;
    private final float open;
    private final float close;
    private final float volume;
    private final long datetime;

    public CandleImpl(float open,
                      float hight,
                      float low,
                      float close,
                      float volume,
                      long datetime
    ) {
        this.hight = hight;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.datetime = datetime;
    }

    @Override
    public float hight() {
        return hight;
    }

    @Override
    public float low() {
        return low;
    }

    @Override
    public float open() {
        return open;
    }

    @Override
    public float closed() {
        return close;
    }

    @Override
    public long timestamp() {
        return datetime;
    }
}
