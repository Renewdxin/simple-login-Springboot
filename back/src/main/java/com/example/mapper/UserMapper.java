package com.example.mapper;

import com.example.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM account WHERE username = #{text} OR email = #{text}")
    Account findByNameorEmail(String text);

    @Insert("INSERT INTO account(username, email, password) VALUES (#{username}, #{email}, #{password})")
    int createAccount(String username, String email, String password);

    @Update("UPDATE account SET password = #{password} WHERE email = #{email}")
    int resetPasswordByEmail(String password, String email);
}
