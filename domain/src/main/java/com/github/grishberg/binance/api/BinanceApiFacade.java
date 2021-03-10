package com.github.grishberg.binance.api;

import com.github.grishberg.binance.domain.Balance;
import com.github.grishberg.binance.domain.BinanceOrder;
import com.github.grishberg.binance.domain.OrderResponse;
import com.github.grishberg.binance.domain.Orders;

import java.util.List;

public interface BinanceApiFacade {
    Orders getOrders();

    /**
     * Balance of trade currency.
     */
    Balance getTradingBalance();

    /**
     * Balance of base currency.
     */
    Balance getBaseBalance();

    double assetBalanceToDouble(Balance balance);

    double getAllTradingBalance();

    boolean tradingBalanceAvailable(Balance tradingBalance);

    List<Balance> getBalances();

    List<BinanceOrder> getOpenedOrders();

    void cancelAllOrders();

    OrderResponse buy(int quantity, double price);

    void sell(int quantity, double price);

    void sellMarket(int quantity);

    BinanceOrder getOrder(long orderId);

    double lastPrice();

    void cancelOrder(long orderId);
}
