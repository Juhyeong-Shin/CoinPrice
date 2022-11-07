package com.example.coinprice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoinNotFoundException extends Throwable {
    public CoinNotFoundException(String message) {
        super(message);
    }
}
