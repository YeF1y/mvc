package com.servlet;


import com.factory.DAOFactory;
import com.vo.Person;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException{
        String path = "login.jsp";
        //1. 接受表单(View)传递过来的参数
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        //2. 把参数进行处理--某个对象的半成品
        Person person = new Person();
        person.setId(id);
        person.setPassword(password);
        //3. 调用DAO的具体CLUD(增删改查)方法
        try{
            if(DAOFactory.getPersonDAOInstance().login(person)){
                request.getSession().setAttribute("uname",person.getName());
                //检测是否本人操作
                request.getSession().setAttribute("uid",person.getId());
                path = "login_success.jsp";
            }else{
                request.setAttribute("err", "错误的用户ID和密码!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //        4. 根据CLUD的结果返回前端某个视图页面
        request.getRequestDispatcher(path).forward(request,response);
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException{
        this.doGet(request,response);
    }
}
