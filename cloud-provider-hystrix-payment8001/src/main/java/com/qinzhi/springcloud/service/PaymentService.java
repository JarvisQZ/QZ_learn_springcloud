package com.qinzhi.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_OK_id" + id + "\t" + "(●'◡'●)";
    }

    public String paymentInfo_TimeOut(Integer id) {
        //暂停几秒
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：  " + Thread.currentThread().getName() + "   paymentInfo_TimeOut_id" + id + "\t" + "(●'◡'●)" + "耗时" + timeNumber + "秒钟";
    }
}