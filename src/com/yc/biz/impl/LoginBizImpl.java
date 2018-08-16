package com.yc.biz.impl;

import java.util.List;
import java.util.Map;

import com.yc.biz.LoginBiz;
import com.yc.util.DBHelper;

public class LoginBizImpl extends LoginBiz {

	@Override
	public List<Map<String, Object>> login(String uname, String pwd) {
		String sql = "select * from regist where uname=? and pwd=?";
		return DBHelper.findAll(sql, uname, pwd);
	}

}
