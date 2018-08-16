package com.yc.biz;

import java.util.List;
import java.util.Map;

public abstract class LoginBiz {
	public abstract List<Map<String,Object>> login(String uname, String pwd);
}
