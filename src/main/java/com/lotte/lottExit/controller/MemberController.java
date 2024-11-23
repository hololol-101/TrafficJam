package com.lotte.lottExit.controller;

import com.lotte.lottExit.model.Member;
import com.lotte.lottExit.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String Login(@RequestParam("id") String id,
                        @RequestParam("password") String password) {
        if(memberService.checkMember(id, password)){
            return "Success";
        }

        return "false";

    }
    @PostMapping("/login")
    public String Register(Member member) {
        if(memberService.registerMember(member)) {
            return "Success";
        }
        return "false";
    }
}

