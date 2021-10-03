package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectController {
    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("/select")
    public String  select(@RequestParam Integer id) {
        return blogMapper.selectById(id).getLog();
    }
}
