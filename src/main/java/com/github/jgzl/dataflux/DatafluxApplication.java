package com.github.jgzl.dataflux;

import com.mzt.logapi.starter.annotation.EnableLogRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLogRecord(tenant = "dataflux")
@SpringBootApplication
public class DatafluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatafluxApplication.class, args);
    }

}
