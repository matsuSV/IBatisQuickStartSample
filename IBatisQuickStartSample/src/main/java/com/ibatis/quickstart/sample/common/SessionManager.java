package com.ibatis.quickstart.sample.common;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import com.ibatis.quickstart.sample.invoke.SqlMapInvoker;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapSession;

/**
 * SqlMapSessionインスタンスを生成するクラス
 *
 * ProxyクラスのnewProxyInstance関数を使用して、SQL発行前後に
 * 任意の処理を挿入する。
 */
public class SessionManager {

	/**
	 * SqlMapSessionクラスの関数を使用する際にSqlMapInvokerクラスの動作を付与する処理を行う
	 * 
	 * @param conn : DBへのコネクション
	 * @return Proxyクラスで生成したSqlMapSessionインスタンス
	 * @throws IOException 
	 */
	public static SqlMapSession getProxySession(Connection conn) throws IOException {
		
		// 発行するSQL文が記載された設定ファイルを読み込み、SqlMapClientのインスタンスを得る
		SqlMapClient sqlMapInstance = ConfigReader.getSqlMapInstance();
		
		// DBへのコネクションからセッション（SqlMapSession）を生成する
		SqlMapSession sqlMapSession = sqlMapInstance.openSession(conn);
		
		// SqlMapSessionクラスの関数を使用する際の動作をカスタマイズする
		// 下記では関数を呼び出したあと、コネクションのクローズ処理を行う設定をする
		SqlMapSession proxyInstance = (SqlMapSession) Proxy.newProxyInstance(SqlMapSession.class.getClassLoader(),
																				new Class[]{SqlMapSession.class},
																				new SqlMapInvoker(sqlMapSession));
		
		return proxyInstance;
	}
}
