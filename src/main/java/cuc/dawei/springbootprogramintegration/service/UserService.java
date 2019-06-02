package cuc.dawei.springbootprogramintegration.service;

import cuc.dawei.springbootprogramintegration.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 17:11
 * @Version 1.0
 */
public interface UserService {
    int insertUser(User user);
    int deleteUser(String name);
    int updateUser( String name1,String name2);
    List<User> getAllUser();
    List<User> getUserById(String id);
}
