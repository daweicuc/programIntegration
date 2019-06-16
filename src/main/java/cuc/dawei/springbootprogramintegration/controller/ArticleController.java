package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.Article;
import cuc.dawei.springbootprogramintegration.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ClassName ArticleController
 * @Description 下面是查看新闻第一个篇文章内容
 * 里面还加了缓存的步骤
 *
 * @Author Mike
 * @Date 2019/6/2 15:49
 * @Version 1.0
 */

@RestController
@RequestMapping(value="unicom",produces = "application/json;charset=utf-8")
@Api(tags = "联通新闻网页接口API")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private RedisHelperImpl redisHelper;
    @RequestMapping(value="article/{id}")
    @ApiOperation(value = "从库中找到第一篇文章")
//    @Cacheable(cacheNames = "getarticle211121")
    public Article getArticle(@PathVariable int id){
        System.out.println("查询文章1");
        boolean exists=redisTemplate.hasKey("article"+id);
        if(exists){
            System.out.println("缓存中的数据："+redisTemplate.opsForValue().get("article"+id));
            return null;
        }else{
            Article article=articleService.getArticle(id);
            redisTemplate.opsForValue().set("article"+id,article);
            return article;
        }


    }

}
