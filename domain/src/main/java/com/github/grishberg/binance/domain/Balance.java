package com.github.grishberg.binance.domain;

public interface Balance {
    /**
     * Available balance.
     */
    Double getFree();

    /**
     * Locked by open orders.
     */
    Double getLocked();
}
