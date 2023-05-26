package com.dao;

import com.vo.Message;
import com.vo.Revert;

import java.util.List;

public interface IRevertDAO {
    public List<Revert> queryAll(int messageID)throws Exception;
    public void insert(Revert revert) throws Exception;
    public void delete(int revertID) throws Exception;
    public void deleteAll(int messageID) throws Exception;
}
