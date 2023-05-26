package com.dao.impl;

import com.dao.IRevertDAO;
import com.db.ConnectionManager;
import com.vo.Message;
import com.vo.Revert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RevertDAOImpl implements IRevertDAO {
    @Override
    public List<Revert> queryAll(int messageID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Revert> listRevert = new ArrayList<Revert>();
        try{
            con = ConnectionManager.getConnection();
            String strsql = "SELECT * FROM revert WHERE messageID=?";
            pstmt = con.prepareStatement(strsql);
            pstmt.setInt(1,messageID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Revert revert = new Revert();
                revert.setRevertID(rs.getInt(1));
                revert.setMessageID(rs.getInt(2));
                revert.setContent(rs.getString(3));
                revert.setWriter(rs.getString(4));
                revert.setWriterDate(rs.getString(5));
                listRevert.add(revert);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionManager.closeStatement(pstmt);
            ConnectionManager.closeConnection(con);
        }
        return listRevert;
    }

    @Override
    public void insert(Revert revert) throws Exception {
        String sql = "INSERT INTO revert(messageID,content,writer,writeDate) VALUES(?,?,?,?)" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn= ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, revert.getMessageID()); ;
            pstmt.setString(2, revert.getContent());
            pstmt.setString(3, revert.getWriter()) ;
            pstmt.setString(4, revert.getWriterDate());
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
    public void delete(int revertID) throws Exception {
        String sql = "DELETE FROM revert WHERE revertID=?" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn=ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,revertID) ;
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
    public void deleteAll(int messageID) throws Exception {
        String sql = "DELETE FROM revert WHERE messageID=?" ;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn=ConnectionManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,messageID) ;
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
}
