package com.example.coinprice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Coin {
    private String api_key;
    private String symbol;
    private String type;
    private String price;
    private String amount;
    private String sign;
}
