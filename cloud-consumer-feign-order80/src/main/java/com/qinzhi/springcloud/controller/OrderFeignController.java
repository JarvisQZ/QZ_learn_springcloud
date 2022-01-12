package com.qinzhi.springcloud.controller;

import com.qinzhi.springcloud.entities.CommonResult;
import com.qinzhi.springcloud.entities.Payment;
import com.qinzhi.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    String paymentFeignTimeOut() {
        //openFeign-ribbon, 客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
