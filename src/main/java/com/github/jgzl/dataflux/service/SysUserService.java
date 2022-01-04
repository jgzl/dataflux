package com.github.jgzl.dataflux.service;

import com.github.jgzl.dataflux.domain.SysUser;
import com.github.jgzl.dataflux.model.LogRecordType;
import com.github.jgzl.dataflux.repository.SysUserRepository;
import com.mzt.logapi.starter.annotation.LogRecordAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SysUserService {

    private final SysUserRepository sysUserRepository;

    public Mono<SysUser> findById(String id) {
        return sysUserRepository.findById(id);
    }

    public Flux<SysUser> findAll(Example<SysUser> of) {
        return sysUserRepository.findAll(of);
    }

    @LogRecordAnnotation(
            success = "创建或者更新了了一个用户「{{#item.account}}」,结果为:{{#_ret}}",
            prefix = LogRecordType.USER, bizNo = "{{#item.account}}")
    public Mono<SysUser> save(SysUser item) {
        return sysUserRepository.save(item);
    }

    public void deleteAllById(List<String> idList) {
        sysUserRepository.deleteAllById(idList);
    }
}
