package com.dao.impl;

import com.dao.IMessageDAO;
import com.db.ConnectionManager;
import com.vo.Message;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements IMessageDAO {

    @Override
    public void insert(Message message) throws Exception {
        String sql = "INSERT INTO message(title,content,writer,writeDate) VALUES(?,?,?,?)" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn= ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, message.getTitle()) ;
            pstmt.setString(2, message.getContent());
            pstmt.setString(3, message.getWriter()) ;
            pstmt.setString(4, message.getWriteDate());
            pstmt.executeUpdate() ;
        }
        catch (Exception e)
        {
            throw new Exception("操作中出现错误！！！") ;
        }
        finally
        {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(conn);
        }
    }

    @Override
    public void update(Message message) throws Exception {
        String sql = "UPDATE message SET title=?,content=? WHERE messageId=?" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn=ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,message.getTitle()) ;
            pstmt.setString(2,message.getContent()) ;
            pstmt.setInt(3,message.getMessageID()) ;
            pstmt.executeUpdate() ;
        }
        catch (Exception e)
        {
            throw new Exception("操作中出现错误！！！") ;
        }
        finally
        {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(conn);
        }
    }

    @Override
    public void delete(int messageID) throws Exception {
        String sql = "DELETE FROM message WHERE messageID=?" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn=ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, messageID) ;
            pstmt.executeUpdate() ;
        }
        catch (Exception e)
        {
            throw new Exception("操作中出现错误！！！") ;
        }
        finally
        {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(conn);
        }
    }

    @Override
    public Message queryById(int id) throws Exception {
        Message message = null ;
        String sql = "SELECT * FROM message WHERE messageID=?" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try
        {
            conn=ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id) ;
            rs = pstmt.executeQuery() ;
            if(rs.next())
            {
                message = new Message() ;
                message.setMessageID(rs.getInt(1));
                message.setTitle(rs.getString(2));
                message.setContent(rs.getString(3));
                message.setWriter(rs.getString(4));
                message.setWriteDate(rs.getString(5));
            }
        }
        catch (Exception e)
        {
            throw new Exception("操作中出现错误！！！") ;
        }
        finally
        {
            ConnectionManager.closeResultSet(rs);
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(conn);
        }
        return message ;
    }

    @Override
    public List<Message> queryAll() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Message> messageList = new ArrayList<Message>();
        try{
            con = ConnectionManager.getConnection();
            String strsql = "SELECT * FROM message";
            pstmt = con.prepareStatement(strsql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Message message = new Message();
                message.setMessageID(rs.getInt(1));
                message.setTitle(rs.getString(2));
                message.setContent(rs.getString(3));
                message.setWriter(rs.getString(4));
                message.setWriteDate(rs.getString(5));
                messageList.add(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return messageList;
    }

    @Override
    public List<Message> queryByLike(String cond) throws Exception {
        return null;
    }
}
