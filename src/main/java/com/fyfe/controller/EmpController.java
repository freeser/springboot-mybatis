package com.fyfe.controller;

import com.fyfe.pojo.Emp;
import com.fyfe.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping("/list")
    public List<Emp> list() {
        List<Emp> list = empService.list();

        return  list;
    }
}
