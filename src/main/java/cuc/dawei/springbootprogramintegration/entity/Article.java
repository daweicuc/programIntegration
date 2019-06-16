package cuc.dawei.springbootprogramintegration.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 下面内容：Article,ArticleExample,Category,CategoryExample,Navbar,NavbarExample,Share,ShareExample
 * /mybatis/mapper/*xml
 * ArticleMapper，CategoryMapper，NavbarMapper，ShareMapper
 * 都是逆向工程操作生成的代码
 */
public class Article  implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String title;

    private Date releaseTime;

    private String user;

    private String content;

    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", releaseTime=" + releaseTime +
                ", user='" + user + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article(Integer id, Integer categoryId, String title, Date releaseTime, String user, String content) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.releaseTime = releaseTime;
        this.user = user;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}