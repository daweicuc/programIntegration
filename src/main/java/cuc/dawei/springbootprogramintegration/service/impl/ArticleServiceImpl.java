package cuc.dawei.springbootprogramintegration.service.impl;

import cuc.dawei.springbootprogramintegration.entity.Article;
import cuc.dawei.springbootprogramintegration.mapper.ArticleMapper;
import cuc.dawei.springbootprogramintegration.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 15:45
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public Article getArticle(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
