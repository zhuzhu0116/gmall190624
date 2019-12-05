package com.atguigu.gmall0624.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall0624.bean.UserAddress;
import com.atguigu.gmall0624.service.UserManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Reference
    private UserManageService userManageService;

    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> trade(UserAddress userAddress){
        return userManageService.getUserAddressByUserId(userAddress);
    }
}
