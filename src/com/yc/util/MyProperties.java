package com.yc.util;

import java.io.IOException;
import java.util.Properties;

public class MyProperties extends Properties {
	private static final long serialVersionUID = 1L;
	
	private static Properties dbProp = new Properties();

	public static Properties getInstance() throws IOException{
		dbProp.setProperty("driverClass", "com.mysql.jdbc.Driver");
		dbProp.setProperty("url", "jdbc:mysql://localhost:3306/loginpage?useUnicode=true&amp;characterEncoding=UTF-8");
		dbProp.setProperty("user", "root");
		dbProp.setProperty("password", "a");
		return dbProp;
	}

}
