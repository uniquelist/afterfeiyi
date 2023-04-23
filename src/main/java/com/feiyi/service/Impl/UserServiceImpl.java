package com.feiyi.service.Impl;

import com.feiyi.dao.UserDao;
import com.feiyi.domain.CountUserByYear;
import com.feiyi.domain.Role;
import com.feiyi.domain.User;
import com.feiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //    注册，添加用户
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
        System.out.println("userid == " + user.getId());
    }

    //    登录，查找用户
    @Override
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public Integer countUser() {
        return userDao.countUser();
    }

    @Override
    public List<CountUserByYear> countByYear() {
        return userDao.countByYear();
    }

    @Override
    public List<Role> findAllRole() {
        return userDao.findAllRole();
    }
}

