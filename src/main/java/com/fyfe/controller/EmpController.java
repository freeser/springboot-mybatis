package com.fyfe.controller;

import com.fyfe.dto.Result;
import com.fyfe.pojo.Emp;
import com.fyfe.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/list")
    public Result list() {
        return Result.buildSuccess(empService.list());
    }
    @GetMapping("/page")
    public Result page(Integer pageNum, Integer pageSize) {
        return Result.buildSuccess(empService.pageList(pageNum, pageSize));
    }

    @PostMapping("/save")
    public Result save(@RequestBody Emp emp) {
        return Result.buildSuccess(empService.insert(emp));
    }
}
