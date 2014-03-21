package com.ibatis.quickstart.sample.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.ibatis.sqlmap.client.SqlMapSession;

/**
 * 実行する関数の前後に、任意の処理を挿入する動作を設定するクラス
 * 
 * InvocationHandlerクラスを実装してinvoke関数を再定義する。
 */
public class SqlMapInvoker implements InvocationHandler {

	/**
	 * SqlMapSessionクラスの関数を呼ぶ前後で任意を処理を実施するため
	 * SqlMapSession型の変数をクラスメンバとして持たせる
	 */
	private SqlMapSession sqlMapSession;

	public SqlMapInvoker(SqlMapSession sqlMapSession) {
		this.sqlMapSession = sqlMapSession;
	}

	/**
	 *  invoke関数を再実装し、Proxy対象の関数を呼んだ際の振る舞いを実装する。
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object aopObject = null;
		try {
			// Proxy対象となる関数を呼ぶ
			aopObject = method.invoke(this.sqlMapSession, args);
		} finally {
			// Proxy対象の関数を呼んだときに、例外が発生したときを考慮してfinally句でクローズ処理
			this.sqlMapSession.close();
		}
		return aopObject;
	}
}
