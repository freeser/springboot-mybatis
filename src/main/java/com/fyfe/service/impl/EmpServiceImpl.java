package com.fyfe.service.impl;

import com.fyfe.mapper.EmpMapper;
import com.fyfe.pojo.Emp;
import com.fyfe.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return empMapper.selectAll();
    }

    @Override
    public PageInfo<Emp> pageList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize); //这个语句必须放在selectAll查询前面
        return new PageInfo<>(empMapper.selectAll());
    }

    @Override
    public int insert(Emp emp) {
        int i = empMapper.insert(emp);
        int a = 1/0;
        return i;
    }

}
