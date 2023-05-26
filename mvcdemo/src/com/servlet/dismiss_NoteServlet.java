package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.factory.DAOFactory;
import com.vo.dismiss_Note;
@WebServlet("/Note")
public class dismiss_NoteServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String path = "errors.jsp";
        // 接收要操作的参数值
        String status = request.getParameter("status");
        if (status != null) {
            // 参数有内容，之后选择合适的方法
            // 查询全部操作
            if ("selectall".equals(status)) {
                try {
                    request.setAttribute("all", DAOFactory.getNoteDAOInstance()
                            .queryAll());
                } catch (Exception e) {
                }
                path = "list_note.jsp";
            }
            // 插入操作
            if ("insert".equals(status)) {
                // 1、接收插入的信息
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String content = request.getParameter("content");
                // 2、实例化VO对象
                dismiss_Note note = new dismiss_Note();
                note.setId(id);
                note.setTitle(title);
                note.setAuthor(author);
                note.setContent(content);
                // 3、调用DAO完成数据库的插入操作
                boolean flag = false;
                try {
                    DAOFactory.getNoteDAOInstance().insert(note);
                    flag = true;
                } catch (Exception e) {
                }
                request.setAttribute("flag", flag);
                path = "insert_do.jsp";
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
                    request.setAttribute("note", DAOFactory
                            .getNoteDAOInstance().queryById(id));
                } catch (Exception e) {
                }
                path = "update_note.jsp";
            }
            // 更新操作
            if ("update".equals(status)) {
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (Exception e) {
                }
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String content = request.getParameter("content");
                dismiss_Note note = new dismiss_Note();
                note.setId(id);
                note.setTitle(title);
                note.setAuthor(author);
                note.setContent(content);
                boolean flag = false;
                try {
                    if(request.getSession().getAttribute("uid").equals(request.getParameter("id"))) {
                        DAOFactory.getNoteDAOInstance().update(note);
                        flag = true;
                    }
                } catch (Exception e) {
                }
                request.setAttribute("flag", flag);
                path = "update_do.jsp";
            }
            // 模糊查询
            if ("selectbylike".equals(status)) {
                String keyword = request.getParameter("keyword");
                try {
                    request.setAttribute("all", DAOFactory.getNoteDAOInstance()
                            .queryByLike(keyword));
                } catch (Exception e) {
                }
                path = "list_note.jsp";
            }
            // 删除操作
            if ("delete".equals(status)) {
                // 接收参数
                int id = 0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                } catch (Exception e) {
                }
                boolean flag = false;
                try {
                    if(request.getSession().getAttribute("uid").equals(request.getParameter("id"))) {
                        DAOFactory.getNoteDAOInstance().delete(id);
                        flag = true;
                    }
                } catch (Exception e) {
                }
                request.setAttribute("flag", flag);
                path = "delete_do.jsp";
            }
        } else {
            // 则表示无参数，非法的客户请求
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        this.doPost(request, response);
    }
}
