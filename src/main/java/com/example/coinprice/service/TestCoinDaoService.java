package com.example.coinprice.service;

import com.example.coinprice.model.TestCoin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        if (testcoin.getSymbol() == null) {
            testcoin.setNum(++testcoinsCount);
        }

        testcoins.add(testcoin);
        return testcoin;
    }
}