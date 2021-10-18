package com.github.jgzl.dataflux;

import com.alibaba.fastjson.JSON;
import com.github.jgzl.dataflux.domain.SysUser;
import com.github.jgzl.dataflux.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
@SpringBootTest
public class DatafluxApplicationTests {

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @Test
    void contextLoads() {
        log.info("开始删除数据");
        sysUserRepository.deleteAll().block(Duration.ofSeconds(10));
        log.info("结束删除数据");
        log.info("开始新增数据");
        sysUserRepository.saveAll(Arrays.asList(
                SysUser.builder().account("lihaifeng1").username("lihaifeng1").nickname("lihaifeng1").age(24).build(),
                SysUser.builder().account("lihaifeng2").username("lihaifeng2").nickname("lihaifeng1").age(24).build(),
                SysUser.builder().account("lihaifeng3").username("lihaifeng3").nickname("lihaifeng1").age(24).build(),
                SysUser.builder().account("lihaifeng4").username("lihaifeng4").nickname("lihaifeng1").age(24).build(),
                SysUser.builder().account("lihaifeng5").username("lihaifeng5").nickname("lihaifeng1").age(24).build()
        )).blockLast(Duration.ofSeconds(10));
        log.info("结束新增数据");
        log.info("开始查询数据");
        ReactiveHashOperations hashOperations = reactiveRedisTemplate.opsForHash();
        String user_key = applicationName+":user";
        sysUserRepository.findAll(Example.of(new SysUser())).doOnNext(item->{
            hashOperations.put(user_key, item.getAccount(), JSON.toJSONString(item));
            Mono mono = hashOperations.get(user_key, item.getAccount());
            mono.subscribe(s->{
                log.info("redis info:{}",JSON.parseObject(s.toString(),SysUser.class));
            });
            log.info(item.toString());
        }).blockLast(Duration.ofSeconds(10));
        log.info("结束查询数据");
        log.info("开始删除数据");
        sysUserRepository.deleteAll().block(Duration.ofSeconds(10));
        log.info("结束删除数据");
    }

}
