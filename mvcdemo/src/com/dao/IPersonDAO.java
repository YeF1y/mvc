package com.dao;

import com.vo.Person;

public interface IPersonDAO {
    // 做登陆验证
    public boolean login(Person person) throws Exception ;
}
