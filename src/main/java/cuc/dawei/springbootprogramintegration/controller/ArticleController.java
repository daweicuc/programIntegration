package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.Article;
import cuc.dawei.springbootprogramintegration.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping(value="unicom")
@Api(tags = "联通新闻网页接口API")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value="article")
    @ApiOperation(value = "从库中找到第一篇文章")
    @Cacheable(cacheNames = "查文章")
    public Article getArticle(){
        System.out.println("查询文章1");
        return articleService.getArticle(1);
    }

}
