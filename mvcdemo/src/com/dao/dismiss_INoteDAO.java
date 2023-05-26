package com.dao;

import com.vo.dismiss_Note;
import java.util.List;

public interface dismiss_INoteDAO {
    // 增加操作
    public void insert(dismiss_Note note) throws Exception ;
    // 修改操作
    public void update(dismiss_Note note) throws Exception ;
    // 删除操作
    public void delete(int id) throws Exception ;
    // 按ID查询，主要为更新使用
    public dismiss_Note queryById(int id) throws Exception ;
    // 查询全部
    public List<dismiss_Note> queryAll() throws Exception ;
    // 模糊查询
    public List<dismiss_Note> queryByLike(String cond) throws Exception ;
}
