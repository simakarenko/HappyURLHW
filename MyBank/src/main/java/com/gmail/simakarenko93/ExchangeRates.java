package com.gmail.simakarenko93;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeRates {
    private static final ExchangeRates ER = new ExchangeRates();

    private final List<String> testER = List.of("USD", "EUR", "UAH");

    public static ExchangeRates getInstance() {
        return ER;
    }


    //проверка правильности ввода имени валюты
    public synchronized boolean checkCurrencyName(String name) throws InvalidInputFormatException {
        for (String t : testER) {
            if (t.equals(name)) {
                return true;
            }
        }
        throw new InvalidInputFormatException("Invalid currency name");
    }

    //перевод по курсу с доллара в евро
    public static synchronized double USDinEUR(double moneyUSD) {
        double result = moneyUSD * 0.91;
        return result;
    }

    //перевод по курсу с доллара в гривну
    public static synchronized double USDinUAH(double moneyUSD) {
        double result = moneyUSD * 36.51;
        return result;
    }

    //перевод по курсу с евро в доллар
    public static synchronized double EURinUSD(double moneyEUR) {
        double result = moneyEUR * 1.1;
        return result;
    }

    //перевод по курсу с евро в гривну
    public static synchronized double EURinUAH(double moneyEUR) {
        double result = moneyEUR * 40.37;
        return result;
    }

    //перевод по курсу с гривны в доллар
    public static synchronized double UAHinUSD(double moneyUAH) {
        double result = moneyUAH * 0.03;
        return result;
    }

    //перевод по курсу с гривны в евро
    public static synchronized double UAHinEUR(double moneyUAH) {
        double result = moneyUAH * 0.02;
        return result;
    }
}
