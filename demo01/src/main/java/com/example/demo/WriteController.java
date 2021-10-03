package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteController {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("/write")
    public Blog write(@RequestParam Integer id,
                      @RequestParam String password,
                      @RequestParam String log) {
        Blog blog = null;
        Account account = accountMapper.selectById(id);
        if ( account != null && password.equals(account.getPassword())) {
            blogMapper.deleteById(id);
            blog = Blog.builder().password(password).id(id).log(log).build();
            blogMapper.insert(blog);
        }
        return blog;
    }
}
