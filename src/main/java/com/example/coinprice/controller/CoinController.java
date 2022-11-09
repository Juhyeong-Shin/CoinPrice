package com.example.coinprice.controller;

import com.example.coinprice.model.Coin;
import com.example.coinprice.service.CoinDaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

/*    @GetMapping("/Coin/{number}")
    public Coin retrieveCoin(@PathVariable int number) {
        Coin coin = service.findOne(number);

        if(coin == null) {
            throw new CoinNotFoundException(String.format("Number[%s] not found", number));
        }

        return coin;
    }*/

    @PostMapping (value = "/api.lbkex.com/v1/user_info.do")
    public ResponseEntity<Object> createCoin(@Valid @RequestBody Coin coin) {
        Coin savedCoin = service.save(coin);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api.lbkex.com/v1/user_info.do")
                .buildAndExpand(savedCoin.getNumber())
                .toUri();

       return ResponseEntity.created(location).build();
    }

}
