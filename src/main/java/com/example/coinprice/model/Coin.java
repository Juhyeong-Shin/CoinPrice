package com.example.coinprice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
