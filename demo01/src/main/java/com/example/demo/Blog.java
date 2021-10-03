package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName
public class Blog {
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "password")
    private String password;
    @TableField(value = "log")
    private String log;
}
