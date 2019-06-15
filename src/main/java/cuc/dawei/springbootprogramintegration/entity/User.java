package cuc.dawei.springbootprogramintegration.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author Mike
 * @Date 2019/6/2 16:58
 * @Version 1.0
 */
@Component
public class User implements Serializable {
    private int id;
    private String name;
    private String pasd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pasd='" + pasd + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, String name, String pasd) {
        this.id = id;
        this.name = name;
        this.pasd = pasd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasd() {
        return pasd;
    }

    public void setPasd(String pasd) {
        this.pasd = pasd;
    }
}
