package com.example.coinprice.dao;

import com.example.coinprice.coin.Coin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinDaoService {
    private static List<Coin> coins =new ArrayList<>();

    private static int coinsCount = 1;

    static{
        coins.add(new Coin(1,null,null,null,null,null,null));
    }
    public List<Coin> findAll() { return coins; }

    public Coin save(Coin coin) {
        if(coin.getNumber() == 1) {
            coin.setNumber(++coinsCount);
        }

        coins.add(coin);
        return coin;
    }

    public Coin findOne() {
        for(Coin coin : coins){
            if(coin.getNumber() == 1) {
                return coin;
            }
        }
        return null;
    }

}
