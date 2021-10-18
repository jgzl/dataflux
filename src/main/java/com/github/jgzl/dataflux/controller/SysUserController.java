package com.github.jgzl.dataflux.controller;

import com.github.jgzl.dataflux.domain.SysUser;
import com.github.jgzl.dataflux.repository.SysUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户控制器
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {

    private SysUserRepository sysUserRepository;

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Mono<SysUser> findById(@PathVariable String id){
        return sysUserRepository.findById(id);
    }

    /**
     * 查找所有用户
     * @return
     */
    @GetMapping
    public Flux<SysUser> findAll(SysUser item){
        return sysUserRepository.findAll(Example.of(item));
    }

    /**
     * 保存用户
     * @param item
     * @return
     */
    @PostMapping
    public Mono<SysUser> save(@RequestBody SysUser item){
        return sysUserRepository.save(item);
    }

    /**
     * 更新用户
     * @param item
     * @return
     */
    @PutMapping
    public Mono<SysUser> update(@RequestBody SysUser item){
        return sysUserRepository.save(item);
    }

    /**
     * 删除用户(支持多个删除)
     * @param id |1,2,3
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        List<String> idList = Arrays.stream(id.split(",")).collect(Collectors.toList());
        if (idList.size()>0&&idList.size()<=10) {
            sysUserRepository.deleteAllById(idList);
        }else {
            throw new IllegalArgumentException("删除数据超过10行!");
        }
    }
}
