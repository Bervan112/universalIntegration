package com.jad.it.springbootmybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jad.it.springbootmybatis.pojo.User;
import com.jad.it.springbootmybatis.service.UserService;

@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private User user;
    //显示用户
    @RequestMapping("list")
    public List<User> index() throws Exception {
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");
        return userService.getUser();
    }
    //删除用户
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"的用户";
    }
    //增加用户
    @RequestMapping("addUser")
    public String addUser() throws Exception {
        user.setAge(33);
        user.setUsername("阿花");
        userService.addUser(user);
        return "增加用户";
    }
}