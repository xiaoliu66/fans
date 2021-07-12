package com.example.fans.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author xiaoliu66@github.com
 * @since 2021/7/5 21:58
 * @version 1.0
 */
public class Fans {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mid;
    private String time;
    private Integer follower;

    public Fans() {
    }

    public Fans(Integer id, String mid, String time, Integer follower) {
        this.id = id;
        this.mid = mid;
        this.time = time;
        this.follower = follower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }
}
