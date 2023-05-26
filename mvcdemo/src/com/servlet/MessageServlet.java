package com.servlet;

import com.factory.DAOFactory;
import com.vo.Message;
import com.vo.dismiss_Note;

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

@WebServlet("/Message")
public class MessageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("uname");
        if(uname==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            String path = "messageErrors.jsp";
            //1.接收表单(View)传递过来的参数
            String status = request.getParameter("status");
            //2. 把参数进行处理--某个对象的半成品

            //3. 调用DAO的具体CLUD(增删改查)方法

            if ("selectall".equals(status)) {//查询所有并显示在帖子管理页
                try {
                    List<Message> allList = DAOFactory.getMessageDAOInstance().queryAll();
                    request.setAttribute("all", allList);
                    path = "list_note.jsp";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if ("delete".equals(status)) {//根据messageID删除某一条帖子,同时删除与之相关的评论
                int messageID = Integer.parseInt(request.getParameter("messageID"));
                boolean flag = false;
                try {
                    DAOFactory.getMessageDAOInstance().delete(messageID);
                    DAOFactory.getRevertDAOInstance().deleteAll(messageID);
                    flag = true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("flag_delete", flag);
                path = "delete_do.jsp";
            }
            // 按ID查询操作，修改之前需要将数据先查询出来
            if ("selectid".equals(status)) {
                // 接收参数
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (Exception e) {
                }
                try {

                    request.setAttribute("message", DAOFactory
                            .getMessageDAOInstance().queryById(id));
                } catch (Exception e) {
                }
                path = "update_note.jsp";
            }

            // 更新操作
            if ("update".equals(status)) {
                //System.out.println(request.getParameter("id"));
                //System.out.println(request.getParameter("writer"));
                //System.out.println(request.getSession().getAttribute("uname"));
                //System.out.println(request.getParameter("content"));
                //System.out.println(request.getParameter("title"));


                int messageID = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String writer = request.getParameter("writer");
                String content = request.getParameter("content");

                Message message = new Message();
                message.setMessageID(messageID);
                message.setTitle(title);
                message.setWriter(writer);
                message.setContent(content);
                boolean flag = false;
                try {
                    //本人才可以进行修改操作，前端已经限制
                    //if(request.getSession().getAttribute("uname").equals(request.getParameter("writer"))) {
                        DAOFactory.getMessageDAOInstance().update(message);
                        flag = true;
                    //}
                } catch (Exception e) {
                }
                request.setAttribute("flag", flag);
                path = "update_do.jsp";
            }

            if ("newMessage".equals(status)) {
                String title = request.getParameter("title");
                String context = request.getParameter("context");
                String writer = (String) session.getAttribute("uname");
                Date writeDate = new Date(System.currentTimeMillis());
                // 创建SimpleDateFormat对象，设置日期格式为SQL中的格式
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 将Date对象转换为字符串
                String dateString = sdf.format(writeDate);

                boolean flag = false;
                try {
                    Message message = new Message();
                    message.setTitle(title);
                    message.setContent(context);
                    message.setWriter(writer);
                    message.setWriteDate(dateString);
                    DAOFactory.getMessageDAOInstance().insert(message);
                    flag = true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                request.setAttribute("flag_newMessage", flag);
                path = "insert_do.jsp";
            }

            //4. 根据CLUD的结果返回前端某个视图页面
            request.setAttribute("uname", uname);
            request.getRequestDispatcher(path).forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException{
        this.doGet(request, response);
    }
}
