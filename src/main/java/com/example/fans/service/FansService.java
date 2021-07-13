package com.example.fans.service;

/**
 * @author xiaoliu66@github.com
 * @since 2021/7/5 21:29
 * @version 1.0
 */
public interface FansService {

    Integer getFans(String uid);

    int insertFans(String uid);
}
