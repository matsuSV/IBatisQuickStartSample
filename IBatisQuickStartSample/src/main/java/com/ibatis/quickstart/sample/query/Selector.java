package com.ibatis.quickstart.sample.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.quickstart.sample.util.LogProvider;

/**
 * main関数からSQL実行処理を委譲されるクラスです。
 *
 */
public class Selector extends QueryCommon {

	public Selector() throws SQLException, IOException {
		super();
	}

	/**
	 * SQLを実行する処理です。
	 * 
	 * @param T
	 * @param namespaceAndId
	 * @param parameter
	 */
	public <T> void execute(Class<T> T, String namespaceAndId, String parameter) {
		
		try {
			List<T> resultList = select(T, namespaceAndId, parameter);

			LogProvider.outputResult(resultList);
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
