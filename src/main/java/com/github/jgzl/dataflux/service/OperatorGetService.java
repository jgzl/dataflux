package com.github.jgzl.dataflux.service;

import com.mzt.logapi.beans.Operator;
import com.mzt.logapi.service.IOperatorGetService;
import org.springframework.stereotype.Service;

@Service
public class OperatorGetService implements IOperatorGetService {
    @Override
    public Operator getUser() {
        Operator operator = new Operator();
        operator.setOperatorId("SYSTEM");
        return operator;
    }
}
