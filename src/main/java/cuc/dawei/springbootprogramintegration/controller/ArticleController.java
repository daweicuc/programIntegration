package cuc.dawei.springbootprogramintegration.controller;

import cuc.dawei.springbootprogramintegration.entity.Article;
import cuc.dawei.springbootprogramintegration.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 15:49
 * @Version 1.0
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value="article")
    public Article getArticle(){
        return articleService.getArticle(1);
    }
}
