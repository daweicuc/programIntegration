package cuc.dawei.springbootprogramintegration.mapper;

import cuc.dawei.springbootprogramintegration.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 17:00
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,pasd) values(#{user.name},#{user.pasd})")
    void insertUser(@Param("user")User user);
    @Delete("delete from user where name=#{name}")
    void deleteUser(@Param("name") String name);
    @Update("update user set name=#{name1} where name=#{name2}")
    void updateUser(@Param("name1") String name1,@Param("name2") String name2);
    @Select("select * from user")
    List<User> getAllUser();
    @Select("select * from user where id=#{id}")
    List<User> getUserById(@Param("id") String id);
}
