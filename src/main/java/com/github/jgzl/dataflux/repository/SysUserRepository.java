package com.github.jgzl.dataflux.repository;

import com.github.jgzl.dataflux.domain.SysUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SysUserRepository extends R2dbcRepository<SysUser,String> {
}
