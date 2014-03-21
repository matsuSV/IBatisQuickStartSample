package com.ibatis.quickstart.sample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ibatis.quickstart.sample.util.LogProvider;

/**
 * データベースとのコネクションを操作するクラスです。
 *
 */
public class ConnectionCommon {
	
	protected Connection conn = null;

	/**
	 * コンストラクタ
	 * 
	 * URL, ユーザー名, パスワードからコネクションを取得する
	 * データは変更させないため、オートコミットをfalseに設定
	 * 
	 * @param url
	 * @param user
	 * @param password
	 * @throws SQLException
	 */
	protected ConnectionCommon(String url, String user, String password) throws SQLException {
		this.conn = DriverManager.getConnection(url, user, password);
		this.conn.setAutoCommit(false);
	}
	
	/**
	 * データベースとのコネクションのクローズ処理
	 */
	protected void closeConnection() {
		if( this.conn != null ) {
			try {
				this.conn.rollback();
			} catch (SQLException se) {
				LogProvider.error("ロールバック処理でエラーが発生しました。", se);
			} finally {
				try {
					this.conn.close();
				} catch (SQLException se) {
					LogProvider.error("コネクションクローズ処理でエラーが発生しました。", se);
				}
			}
		}
		LogProvider.info("コネクションクローズ処理が終わりました。");
	}
}
