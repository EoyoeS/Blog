package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {
    @Autowired
    AccountMapper accountMapper;

    @PostMapping("")
    public Account register(@RequestParam Integer id, @RequestParam String password) {
        Account account = null;
        if(accountMapper.selectById(id) == null) {
            account = Account.builder().password(password).id(id).build();
            accountMapper.insert(account);
        }
        return account;
    }
}
