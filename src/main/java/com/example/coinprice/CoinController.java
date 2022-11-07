package com.example.coinprice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class CoinController {

    private static CoinDaoService service;

    public CoinController (CoinDaoService service){
        this.service = service;
    }


    @GetMapping("/coin")
    public List<Coin> retrieveAllCoin(){
        return service.findAll();
    }

    @PostMapping (value = "/coin///api.lbkex.com/v1/user_info.do")
    public void createCoin(@Valid @RequestBody Coin coin) {
        Coin savedUser = service.save(coin);

    }

}
