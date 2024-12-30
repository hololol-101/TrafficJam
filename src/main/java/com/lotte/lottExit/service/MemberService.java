package com.lotte.lottExit.service;

import com.lotte.lottExit.mapper.MemberMapper;
import com.lotte.lottExit.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private List<Member> memberList;
    public MemberService() {
        memberList = new ArrayList<>();
    }

    MemberMapper memberMapper;
    public boolean registerMember(Member member){
        for(Member m:memberList){
            if (m.getId().equals(member.getId())){
                return false;
            }
        }
        memberList.add(member);
        return true;
    }

    public boolean checkMember(String id, String password){
        for(Member m:memberList){
            if(m.getId().equals(id)&&m.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String id, String password){
        Member mem = memberMapper.getMember(id);

        if(mem.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}
