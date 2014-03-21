package com.ibatis.quickstart.sample.query;

import java.io.IOException;
import java.sql.SQLException;

import com.ibatis.quickstart.sample.util.LogProvider;

public class Inserter extends QueryCommon {
	
	public Inserter() throws SQLException, IOException {
		super();
	}

	public void run(String namespaceAndId, String parameter) {
		
		try {
			int result = insert(namespaceAndId, parameter);
			
			LogProvider.info("insert row = " + result);
			LogProvider.info("success end");
		} catch (SQLException e) {
			if( super.conn == null) {
				LogProvider.error("コネクション取得で例外が発生しました。", e);
			} else {
				LogProvider.error("プロパティ取得で例外が発生しました。", e);
			}
		} finally {
			closeConnection();
		}
	}
	
	public void run(String namespaceAndId) {
		
		try {
			insert(namespaceAndId);
			
			LogProvider.info("success end");
		} catch (SQLException e) {
			if( super.conn == null) {
				LogProvider.error("コネクション取得で例外が発生しました。", e);
			} else {
				LogProvider.error("プロパティ取得で例外が発生しました。", e);
			}
		} finally {
			closeConnection();
		}
	}
}
