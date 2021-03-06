package cuc.dawei.springbootprogramintegration.service.impl;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.mapper.UserMapper;
import cuc.dawei.springbootprogramintegration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 17:14
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return 0;
    }

    @Override
    public int deleteUser(String name) {
        userMapper.deleteUser(name);
        return 0;
    }

    @Override
    public int updateUser(String name1, String name2) {
        int q1=userMapper.updateUser(name1,name2);
        return q1;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listUser=new ArrayList<>();
        userMapper.getAllUser();
        return userMapper.getAllUser();
    }


    @Override
    public User getUserById(int id) {
        userMapper.getUserById(id);
        return null;
    }
}
