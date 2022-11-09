package com.example.coinprice.service;

import com.example.coinprice.response.ResBatchCreateOrderVo;
import com.example.coinprice.response.ResCreateOrderVo;
import com.example.coinprice.response.ResUserInfoVo;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LBankJavaApiService {
    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/user_info.do")
    Call<ResUserInfoVo> getUserInfo();

    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/create_order.do")
    Call<ResCreateOrderVo> createOrder(@Query("symbol") String symbol, @Query("type") String type, @Query("price") String price, @Query("amount") String amount, @Query("custom_id") String customId);


    @Headers("contentType:application/x-www-form-urlencoded")
    @POST("/v2/batch_create_order.do")
    Call<ResBatchCreateOrderVo> batchCreateOrder(@Query("orders") String orders);
}

