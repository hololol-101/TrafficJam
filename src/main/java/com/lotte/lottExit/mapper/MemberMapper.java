package com.lotte.lottExit.mapper;

import com.lotte.lottExit.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member getMember(String id);
}

