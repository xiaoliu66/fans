package com.example.fans.controller;

import com.example.fans.service.FansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoliu66@github.com
 * @since 2021/7/5 20:26
 * @version 1.0
 */
@RestController
@RequestMapping("/b")
public class FansController {
    @Autowired
    private FansService FansService;


    @GetMapping("/getFansByUid")
    public String getFansByUid(String uid) {
        Integer fans = FansService.getFans(uid);
        if (fans != null) {
            return String.valueOf(fans);
        }

        return "获取粉丝信息失败！";
    }
}
