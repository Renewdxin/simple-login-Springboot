package com.example.mapper;

import com.example.entity.account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from account where username = #{text} or email = #{text}")
    account findByNameorEmail(String text);
}
