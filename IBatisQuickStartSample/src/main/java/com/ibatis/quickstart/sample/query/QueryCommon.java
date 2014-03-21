package com.ibatis.quickstart.sample.query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.quickstart.sample.common.SessionManager;
import com.ibatis.quickstart.sample.db.Connection;
import com.ibatis.sqlmap.client.SqlMapSession;

public class QueryCommon extends Connection {
	
	private SqlMapSession sqlMapSession;

	protected QueryCommon() throws SQLException, IOException {
		super();

		// SqlMapSessionのインスタンスを取得する
		this.sqlMapSession = SessionManager.getProxySession(super.conn);
	}

	/**
	 * String型のパラメータを受け取りSELECT句を発行する処理
	 * 
	 * @param T              : SQL結果を格納するクラス
	 * @param namespaceAndId : 発行するSQLを指定するための一意となる文字列（sqlMap要素のnamespace属性 + select要素のid属性）
	 * @param parameter      : SQLへ渡すパラメータ
	 * @return               : SQL結果
	 * @throws IOException
	 * @throws SQLException
	 */
	public <T> List<T> select( Class<T> T, String namespaceAndId, String parameter ) throws SQLException {
		@SuppressWarnings("unchecked")
		List<T> queryForList = this.sqlMapSession.queryForList(namespaceAndId, parameter);
		return queryForList;
	}
	
	/**
	 * String型のパラメータを受け取りINSERT句を発行する処理
	 * 
	 * @param namespaceAndId : 発行するSQLを指定するための一意となる文字列（sqlMap要素のnamespace属性 + select要素のid属性）
	 * @param parameter      : SQLへ渡すパラメータ
	 * @return               : データ挿入数
	 * @throws IOException
	 * @throws SQLException
	 */
	public int insert(String namespaceAndId, String parameter) throws SQLException {
		int result = (Integer) this.sqlMapSession.insert(namespaceAndId, parameter);
		return result;
	}
	
	/**
	 * パラメータなしのINSERT句を発行する処理
	 * 
	 * @param namespaceAndId : 発行するSQLを指定するための一意となる文字列（sqlMap要素のnamespace属性 + select要素のid属性）
	 * @throws IOException
	 * @throws SQLException
	 */
	public void insert(String namespaceAndId) throws SQLException {
		this.sqlMapSession.insert(namespaceAndId);
	}
}
