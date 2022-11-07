package com.example.coinprice.coin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coin {
    private int number;
    private String api_key;
    private String symbol;
    private String type;
    private String price;
    private String amount;
    private String sign;
}
