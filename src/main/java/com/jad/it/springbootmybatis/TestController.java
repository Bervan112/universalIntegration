package com.jad.it.springbootmybatis;

import com.jad.it.springbootmybatis.pojo.User;
import com.jad.it.springbootmybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private User user;
    //显示用户
    @RequestMapping("test")
    public List<User> index() throws Exception {
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");
        return userService.getUser();
    }

}
