package com.github.jgzl.dataflux.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("sys_user")
public class SysUser {
    @Id
    private String id;
    private String account;
    private String username;
    private String nickname;
    private String email;
    private Integer age;
}
