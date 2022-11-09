package com.example.coinprice.service;

import com.example.coinprice.client.LBankJavaApiSdkServiceGenerator;
import com.example.coinprice.response.ResCreateOrderVo;
import com.example.coinprice.response.ResUserInfoVo;
import org.apache.commons.lang3.StringUtils;

/**
 * @author steel.cheng
 */
public class LBankServiceImpl {

    private LBankJavaApiService lBankJavaApiService;

    public LBankServiceImpl(String apiKey, String secret, String signMethod) {
        lBankJavaApiService = LBankJavaApiSdkServiceGenerator.createService(LBankJavaApiService.class, apiKey, secret, signMethod);
    }

    /**
     * 获取用户账户资产信息
     *
     * @return
     */
    public ResUserInfoVo getUserInfo() throws Exception {
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.getUserInfo());
    }

    /**
     * 下单
     *
     * @param symbol   交易对
     * @param type     委托买卖类型buy/sell
     * @param price    下单价格
     * @param amount   交易数量
     * @param customId 自定义ID
     * @return
     */
    public ResCreateOrderVo createOrder(String symbol, String type, String price, String amount, String customId) throws Exception {
        if (StringUtils.isEmpty(symbol)) {
            throw new Exception("symbol参数为空");
        }
        if (StringUtils.isEmpty(type)) {
            throw new Exception("type参数为空");
        }
        if (StringUtils.isEmpty(price)) {
            throw new Exception("price参数为空");
        }
        if (StringUtils.isEmpty(amount)) {
            throw new Exception("amount参数为空");
        }
        return LBankJavaApiSdkServiceGenerator.executeSync(this.lBankJavaApiService.createOrder(symbol, type, price, amount, customId));
    }

}
