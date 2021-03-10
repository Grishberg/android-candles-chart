package com.github.grishberg.candles;

import android.util.Log;

import com.github.grishberg.binance.domain.AppLogger;

public class LogcatLogger implements AppLogger {
    private static final String TAG = "<DBG>";
    @Override
    public void info(String msg) {
        Log.i(TAG, msg);
    }

    @Override
    public void debug(String msg) {
        Log.d(TAG, msg);
    }

    @Override
    public void error(String msg) {
        Log.e(TAG, msg);
    }

    @Override
    public void error(String msg, Throwable t) {
        Log.i(TAG, msg, t);
    }
}
