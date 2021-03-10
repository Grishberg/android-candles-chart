package com.github.grishberg.binance.domain;

import com.github.grishberg.binance.api.BinanceApiFacade;

public class Trader {
    private final BinanceApiFacade api;
    private final Timer timer;
    private final AppLogger appLogger;

    public Trader(
            BinanceApiFacade api,
            Timer timer,
            AppLogger appLogger) {
        this.api = api;
        this.timer = timer;
        this.appLogger = appLogger;
        timer.addTickListener(new TimerTickListener());
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    private class TimerTickListener implements Runnable {
        @Override
        public void run() {

        }
    }
}
