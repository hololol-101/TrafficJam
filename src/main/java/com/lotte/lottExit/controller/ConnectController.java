package com.lotte.lottExit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/example")
@RestController
public class ConnectController {
    @GetMapping("test")
    public void getTest(){
        System.out.println("테스트 컨트롤러");
    }
}
