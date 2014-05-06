package com.ibatis.quickstart.sample.db;

import java.sql.SQLException;

public class Connection extends ConnectionCommon {

	private static String URL      = "";
	private static String USER     = "";
	private static String PASSWORD = "";

	protected Connection() throws SQLException {
		super(URL, USER, PASSWORD);
	}

}
