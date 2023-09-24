package com.example.mapper;

import com.example.entity.account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from account where username = #{text} or email = #{text}")
    account findByNameorEmail(String text);

    @Insert("INSERT INTO account(username, email, password) VALUES (#{username}, #{email}, #{password})")
    int createAccount(String username, String email, String password);
}
