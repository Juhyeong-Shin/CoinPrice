package com.example.coinprice.dao;

import com.example.coinprice.coin.Coin;
import com.example.coinprice.coin.TestCoin;

import java.util.ArrayList;
import java.util.List;

public class TestCoinDaoService {
    private static List<TestCoin> testcoins = new ArrayList<>();

    private static int testcoinsCount = 1;

    static {
        testcoins.add(new TestCoin(1, null));
    }

    public List<TestCoin> testfindAll() {
        return testcoins;
    }

    public TestCoin saved(TestCoin testcoin) {
        if (testcoin.getNum() == 0) {
            testcoin.setNum(++testcoinsCount);
        }

        testcoins.add(testcoin);
        return testcoin;
    }
}