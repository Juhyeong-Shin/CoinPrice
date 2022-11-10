package com.example.coinprice.controller;

import com.example.coinprice.model.TestCoin;
import com.example.coinprice.response.ResUserInfoVo;
import com.example.coinprice.service.TestCoinDaoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/application/x-www-form-urlencoded")
public class  TestCoinController {

    private static TestCoinDaoService serviced;

    public TestCoinController(TestCoinDaoService serviced) {
        this.serviced = serviced;
    }


    @PostMapping("/api.lbkex.com/v1/ticker.dot2")
    public String retrieveAllTestCoin(@Valid @RequestHeader ("application/x-www-form-urlencoded") ) {

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api.lbkex.com/v1/user_info.do")
                .buildAndExpand(savedCoin.getSymbol())
                .toUri();
        return String;
    }

//  getmapping으로 name : symbol type : String 해서 포스트매핑에 있는 헤더값을 여기로 넣고 호출,,
    @GetMapping(value = "/v2/accuracy.do")
    public ResponseEntity<Object> Test (@RequestHeader("") TestCoin testcoin) {
        TestCoin savedCoin = serviced.saved(testcoin);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api.lbkex.com/v1/user_info.do")
                .buildAndExpand(savedCoin.getSymbol())
                .toUri();
        return ResponseEntity.created(location).build();
    }

/*
    @PostMapping (value = "/Test/api.lbkex.com")
    public ResponseEntity<Object> createCoin(@Valid @RequestBody TestCoin testcoin) {
        TestCoin savedCoin = serviced.saved(testcoin);

        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/api.lbkex.com/v1/user_info.do")
                .buildAndExpand(savedCoin.getSymbol())
                .toUri();

        return ResponseEntity.created(location).build();
    }
*/

    @PostMapping(headers = "/v2/supplement/api_Restrictions.do")
    public ResponseEntity<Object> createTest (@Valid @RequestHeader HttpHeaders header) {
//        Test savedTest =serviced.saved(test);

//        URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{Symbol}")
//                .buildAndExpand(savedTest.getSymbol())
//                .toUri();

       return ResponseEntity.ok().body(header.getFirst( "/v2/supplement/api_Restrictions.do"));
    }

//    @PutMapping("/users/{id}")
//    @Operation(summary = "Update a user's name",
//            responses = {
//                    @ApiResponse(responseCode = "200",
//                            description = "Returns the updated user",
//                            content = @Content(mediaType = "application/x-www-form-urlencoded",
//                                    schema = @Schema(implementation = User.class)))
//            });

}
