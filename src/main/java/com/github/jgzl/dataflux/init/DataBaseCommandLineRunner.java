package com.github.jgzl.dataflux.init;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class DataBaseCommandLineRunner implements CommandLineRunner {

    private DatabaseClient databaseClient;

    @Override
    public void run(String... args) throws Exception {
        log.info("开始初始化数据库数据");
        DatabaseClient.GenericExecuteSpec sql = databaseClient.sql("select 1");
        log.info("结束初始化数据库数据");
    }
}
