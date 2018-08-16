package com.yc.cotroller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.util.DBHelper;

@WebServlet("/regist.servlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String rname = request.getParameter("rname");
//		response.getWriter().println(rname);
		
		String sql="select * from regist where uname=?";
		List<Map<String, Object>> result = DBHelper.findAll(sql, rname);
		if(result.size()>0){
			response.getWriter().println("该用户名已被注册，请重新输入！");
		}else{
			response.getWriter().println("该用户名可以注册！");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
