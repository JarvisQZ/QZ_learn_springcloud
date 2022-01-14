package com.qinzhi.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qinzhi.springcloud.entities.CommonResult;
import com.qinzhi.springcloud.entities.Payment;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义的，global", new Payment(2020L, "serial11112222"));
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义的，global", new Payment(2020L, "serial11112222"));
    }
}
