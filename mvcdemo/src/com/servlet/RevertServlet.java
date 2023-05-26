package com.servlet;

import com.factory.DAOFactory;
import com.vo.Message;
import com.vo.Revert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/RevertMessage")
public class RevertServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        if (uname == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String path = "revertErrors.jsp";
            //1.接收表单(View)传递过来的参数
            String status = request.getParameter("status");
            //2. 把参数进行处理--某个对象的半成品

            //3. 调用DAO的具体CLUD(增删改查)方法

            if ("revertMessage".equals(status)) {//从数据库中取出帖子详情和回帖详情发送给jsp页面
                try {
                    int messageID = Integer.parseInt(request.getParameter("messageID"));
                    Message message = DAOFactory.getMessageDAOInstance().queryById(messageID);
                    request.setAttribute("messageDetail", message);
                    List<Revert> listRevert = DAOFactory.getRevertDAOInstance().queryAll(messageID);
                    request.setAttribute("listRevert", listRevert);
                    path = "revertMessage.jsp";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if ("newRevert".equals(status)) {
                int messageID = Integer.parseInt(request.getParameter("messageID"));
                String context = request.getParameter("content");
                String writer = request.getParameter("writer");
                Date writeDate = new Date(System.currentTimeMillis());
                // 创建SimpleDateFormat对象，设置日期格式为SQL中的格式
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 将Date对象转换为字符串
                String dateString = sdf.format(writeDate);

                boolean flag = false;
                try {
                    Revert revert = new Revert();
                    revert.setMessageID(messageID);
                    revert.setContent(context);
                    revert.setWriter(writer);
                    revert.setWriterDate(dateString);
                    DAOFactory.getRevertDAOInstance().insert(revert);
                    flag = true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("flag_newRevert", flag);
                path = "insert_revert_do.jsp?messageID="+messageID;
            }

            if("delete".equals(status)){
                int messageID = Integer.parseInt(request.getParameter("messageID"));
                int revertID = Integer.parseInt(request.getParameter("revertID"));
                boolean flag = false;

                System.out.println(request.getParameter("messageID"));
                System.out.println(request.getParameter("revertID"));

                try {
                    //与帖子不同，评论区还允许自己删除，故在此限制，服了，ID类型不一样，限制不了
                    //if(request.getSession().getAttribute("uid").equals(request.getParameter("messageID"))
                    //        ||request.getSession().getAttribute("uid").equals(request.getParameter("revertID"))) {
                        DAOFactory.getRevertDAOInstance().delete(revertID);
                        flag = true;
                    //}
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("flag_deleteRevert", flag);
                path = "delete_revert_do.jsp?messageID="+messageID;
            }

            //4. 根据CLUD的结果返回前端某个视图页面
            request.setAttribute("uname", uname);
            request.getRequestDispatcher(path).forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }
}
