package com.github.grishberg.binance.domain;

public interface AppLogger {
    void info(String msg);
    void debug(String msg);
    void error(String msg);
    void error(String msg, Throwable t);
}
