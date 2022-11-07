package com.example.coinprice.controller;

import com.example.coinprice.coin.Coin;
import com.example.coinprice.coin.TestCoin;
import com.example.coinprice.dao.TestCoinDaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URI;


@RestController
@RequestMapping("/application/x-www-form-urlencoded")
public class TestCoinController {

    private static TestCoinDaoService serviced;

    @GetMapping(value = "/Test")
    public String Test (@RequestHeader("") String value) {
        System.out.println("application/x-www-form-urlencoded" + value);
        return value;
    }

    @PostMapping (value = "/Test/api.lbkex.com")
    public ResponseEntity<Object> createCoin(@Valid @RequestBody TestCoin testcoin) {
        TestCoin savedCoin = serviced.saved(testcoin);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api.lbkex.com/v1/user_info.do")
                .buildAndExpand(savedCoin.getSymbol())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/v2/supplement/api_Restrictions.do")
    public Test register(@RequestHeader("contentType:application/x-www-form-urlencoded") String name) {
        Test newTest = new Test(counter.incrementAndGet(), name);
        return testRepository.addTest(newTest);
    }

    @PutMapping("/users/{id}")
    @Operation(summary = "Update a user's name",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns the updated user",
                            content = @Content(mediaType = "application/x-www-form-urlencoded",
                                    schema = @Schema(implementation = User.class)))
            })
}
