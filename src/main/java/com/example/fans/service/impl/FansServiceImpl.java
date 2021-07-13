package com.example.fans.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.fans.domain.Fans;
import com.example.fans.mapper.FansMappper;
import com.example.fans.service.FansService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author xiaoliu66@github.com
 * @since 2021/7/5 21:32
 * @version 1.0
 */
@Service
public class FansServiceImpl implements FansService {
    private Integer fans;
    private static final Logger logger = LoggerFactory.getLogger(FansServiceImpl.class);

    @Autowired
    private FansMappper fansMappper;

    @Override
    public Integer getFans(String uid) {
        if (uid == null) {
            uid = "466272";
        }

        String url = "https://api.bilibili.com/x/relation/stat?vmid=" + uid;
        OkHttpClient client = new OkHttpClient();
        //创建一个request对象
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            logger.info("result ---> {}",result);
            if (result.contains("请求错误")) {
                return null;
            }
            Map map = (Map) JSON.parse(result);
            logger.info("map ---> {}",map);

            Map up = (Map) map.get("data");
            fans = (Integer) up.get("follower");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fans;
    }

    @Transactional
    @Override
    public int insertFans(String uid) {
        Integer fans = getFans(uid);
        Fans f = new Fans(null, uid, LocalDateTime.now().toString(), fans);
        fansMappper.insert(f);
        return fans;
    }
}
