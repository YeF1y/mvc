package com.dao;

import com.vo.Message;

import java.util.List;

public interface IMessageDAO {
    //增加操作
    public void insert(Message message) throws Exception;
    //修改操作
    public void update(Message message) throws Exception;
    //删除操作
    public void delete(int messageID) throws Exception;
    //按ID查询, 主要为更新使用
    public Message queryById(int id) throws Exception;
    //查询全部
    public List<Message> queryAll() throws Exception;
    //模糊查询
    public List<Message> queryByLike(String cond) throws Exception;

}

