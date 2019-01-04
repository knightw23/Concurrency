package com.rock.threadLocal.controller;

import com.rock.threadLocal.RequestHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/threadLocal")
public class ThreadLocalController {

    @RequestMapping(value = "/test")
    public Long test() {
        return RequestHolder.getId();
    }
}
