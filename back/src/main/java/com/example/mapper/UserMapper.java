package com.example.mapper;

import com.example.entity.auth.Account;
import com.example.entity.user.accountUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM account WHERE username = #{text} OR email = #{text}")
    Account findAccountByNameorEmail(String text);

    @Select("SELECT * FROM account WHERE username = #{text} OR email = #{text}")
    accountUser findAccountUserByNameorEmail(String text);

    @Insert("INSERT INTO account(username, email, password) VALUES (#{username}, #{email}, #{password})")
    int createAccount(String username, String email, String password);

    @Update("UPDATE account SET password = #{password} WHERE email = #{email}")
    int resetPasswordByEmail(String password, String email);
}
