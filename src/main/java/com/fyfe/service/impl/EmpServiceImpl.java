package com.fyfe.service.impl;

import com.fyfe.mapper.EmpMapper;
import com.fyfe.pojo.Emp;
import com.fyfe.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return empMapper.selectAll();
    }
}
