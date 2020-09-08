package cn.beanbang.urlpost.controller;

import cn.beanbang.urlpost.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    PostService postService;

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping(value = "/postUrl", produces = MediaType.APPLICATION_JSON_VALUE)
    public String postUrl() {
        return postService.postUrl();
    }
}
