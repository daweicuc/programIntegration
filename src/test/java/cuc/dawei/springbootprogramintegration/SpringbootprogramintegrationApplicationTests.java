package cuc.dawei.springbootprogramintegration;

import cuc.dawei.springbootprogramintegration.entity.User;
import cuc.dawei.springbootprogramintegration.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootprogramintegrationApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserMapper userMapper;

    /**
     * Redis常见的五大数据类型：
     *      *  stringRedisTemplate.opsForValue();[String(字符串)]
     *      *  stringRedisTemplate.opsForList();[List(列表)]
     *      *  stringRedisTemplate.opsForSet();[Set(集合)]
     *      *  stringRedisTemplate.opsForHash();[Hash(散列)]
     *      *  stringRedisTemplate.opsForZSet();[ZSet(有序集合)]
     */

//新增
    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().append("msg","hello");
    }
//获取值
    @Test
    public void testRedis1(){
        String i=stringRedisTemplate.opsForValue().get("msg");
        System.out.println(i);
    }
//    List
    @Test
    public void testRedis2(){
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        stringRedisTemplate.opsForList().leftPush("mylist","5");
        stringRedisTemplate.opsForList().leftPush("mylist","6");
        System.out.println(stringRedisTemplate.opsForList().range("mylist",1,4));
    }
//测试保存对象
    @Test
    public void testRedis3(){
        User user1= userMapper.getUserById(2);
        System.out.println(user1);
//        redisTemplate.opsForValue().set("user1",user1);//系统自动配置
        stringRedisTemplate.opsForValue().set("user1",user1.getName());
    }

    @Test
    public void contextLoads() {
    }
}
