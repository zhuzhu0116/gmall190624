package com.atguigu.gmall0624.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall0624.bean.UserAddress;
import com.atguigu.gmall0624.bean.UserInfo;
import com.atguigu.gmall0624.service.UserManageService;
import com.atguigu.gmall0624.user.mapper.UserAddressMapper;
import com.atguigu.gmall0624.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class UserInfoServiceImpl implements UserManageService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override

    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserInfo> selectUserList(UserInfo userInfo) {
        return null;
    }

    @Override
    public List<UserInfo> selectUserListByLike(UserInfo userInfo) {
        return null;
    }

    @Override
    public UserInfo selectUserById(String id) {
        return null;
    }

    @Override
    public UserInfo selectOneUser(UserInfo userInfo) {
        return null;
    }

    @Override
    public void addUser(UserInfo userInfo) {

    }

    @Override
    public void updUser(UserInfo userInfo) {

    }

    @Override
    public void updUserById(UserInfo userInfo) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteUser(UserInfo userInfo) {

    }

    @Override
    public void deleteUsers(String begin, String end) {

    }

    @Override
    public List<UserAddress> getUserAddressByUserId(UserAddress userAddress) {

        return userAddressMapper.select(userAddress);
    }
}
