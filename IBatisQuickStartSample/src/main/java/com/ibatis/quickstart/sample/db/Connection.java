package com.ibatis.quickstart.sample.db;

import java.sql.SQLException;

public class Connection extends ConnectionCommon {

	private static String URL      = "jdbc:oracle:thin:@(DESCRIPTION=(ENABLE=BROKEN)(ADDRESS_LIST=(FAILOVER=ON)(LOAD_BALANCE=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dev-crs-13-scan.dv.jp.honda.com)(PORT=1521)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=s_lcmdb)))";
	private static String USER     = "lcmdb";
	private static String PASSWORD = "lcmdb";

	protected Connection() throws SQLException {
		super(URL, USER, PASSWORD);
	}

}
