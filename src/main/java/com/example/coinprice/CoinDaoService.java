package com.example.coinprice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CoinDaoService {
    private static List<Coin> coin =new ArrayList<>();

    private static int coinCount = 1;

    static{
        coin.add(new Coin(null,null,null,null,null,null));
    }

    public Coin save(Coin coin) {
        if(coin.getid() == null)    {
            coin.setId()(++coinCount);
        }
    }
    public static List<Coin> findAll() {
        return coin;
    }
}
