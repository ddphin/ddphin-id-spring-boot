package com.ddphin.id.demo.controller;

import com.ddphin.id.endpoint.DDphinUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoUserController
 *
 * @Date 2019/8/15 下午2:40
 * @Author ddphin
 */
@RestController
@RequestMapping("/user")
public class DemoUserController {
    @Autowired
    private DDphinUserService ddphinUserService;

    @GetMapping("/nextId")
    public Object nextId() {
        return  ddphinUserService.nextUserId();
    }
}
