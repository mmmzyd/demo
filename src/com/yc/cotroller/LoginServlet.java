package com.yc.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.biz.LoginBiz;
import com.yc.biz.impl.LoginBizImpl;

@WebServlet("/login.servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginBiz lb = new LoginBizImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取会话
		HttpSession session = request.getSession();
		//获取验证码
		String vscode = (String) session.getAttribute("vscode");
		
		if(vscode != null){
			//取出用户输入的验证码
			String inputVscode = request.getParameter("vscode");
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			
			if(vscode.equalsIgnoreCase(inputVscode)){
				//调用用户登录服务方法
				lb.login(uname, pwd);
				response.getWriter().println("欢迎"+request.getParameter("uname")+"登录系统");
				response.sendRedirect("success.jsp");
			}else{
				response.getWriter().println("验证码错误！");
			}
		}else{
			response.getWriter().println("请刷新验证码！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
