package com.github.jgzl.dataflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<String,String> map;

    @BeforeAll
    public static void init() {
        map = new ConcurrentHashMap<>();
    }

    @Test
    public void test_put_success() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int count = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        Runnable runnable = () -> {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            map.put(uuid,uuid+"-"+uuid);
            try {
                //log.error("线程"+Thread.currentThread().getId()+"睡眠开始");
                Thread.sleep(1);
                //log.error("线程"+Thread.currentThread().getId()+"睡眠结束");
            } catch (InterruptedException e) {
                //log.error("线程"+Thread.currentThread().getId()+"睡眠失败",e);
            }
            countDownLatch.countDown();
        };
        for (int i = 0; i < count; i++) {
            //log.info("开始执行i:{}",i);
            executorService.submit(runnable);
            //log.info("结束执行i:{}",i);
        }
        countDownLatch.await();
        //log.error("开始打印concurrentHashMap");
        ConcurrentHashMap.KeySetView<String, String> keySetView = map.keySet();
        for (String key : keySetView) {
            String value = map.get(key);
            //log.info("map key:{},value:{}",key,value);
        }
        //log.error("开始打印concurrentHashMap");
    }
}
