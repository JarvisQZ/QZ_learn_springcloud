package com.qinzhi.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_OK_id" + id + "\t" + "(●'◡'●)";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //暂停几秒
        int timeNumber = 3;
//        int a = 10 / 0; //任何错误都会处理，进行服务降级
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_TimeOut_id" + id + "\t" + "(●'◡'●)" + "耗时" + timeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   系统繁忙，请稍后再试" + id + "\t" + "😄😄😄😄😄";
    }
}