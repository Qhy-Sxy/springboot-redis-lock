package com.aaa.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 钱浩洋
 * @date 2019/11/20 - 14:32
 */
public class Items implements Serializable {
    private Integer id;
    private String name;
    private Float price;
    private String detail;
    private String pic;
    private Date createtime;

    public Items() {
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public Items(Integer id, String name, Float price, String detail, String pic, Date createtime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.pic = pic;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
