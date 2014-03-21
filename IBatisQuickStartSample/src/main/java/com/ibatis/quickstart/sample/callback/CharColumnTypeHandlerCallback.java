package com.ibatis.quickstart.sample.callback;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OraclePreparedStatement;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

/**
 * <typeHandler>タグのcallback属性でしているするクラス
 * 
 * JDBCのPreparedStatementのsetCharメソッドは空白埋めを行わない。
 * そのため、CHAR型のカラム値の比較を行う場合はSQL文で考慮する必要がある。
 * TypeHandlerCallbackを実装した本クラスを用いることで、
 * 
 * setChar()使用時に、OraclePreparedStatementのsetFixedChar()を使用するように実装する。
 *
 */
public class CharColumnTypeHandlerCallback implements TypeHandlerCallback {

	@Override
	public Object getResult(ResultGetter arg0) throws SQLException {
		return arg0.getObject();
	}

	@Override
	public void setParameter(ParameterSetter arg0, Object arg1) throws SQLException {

		// 下記の関数を呼ばないとログが出力されないため、ログ出力目的で実行
		arg0.setString( (String) arg1 );

		// PreparedStatementインスタンスを取得する
		PreparedStatement ps = arg0.getPreparedStatement();
		
		// オラクル用のPreparedStatementインスタンスを取得するためunwrap関数を呼ぶ（setFixedCHAR関数がオラクルから提供されている関数のため）
		OraclePreparedStatement ops = ps.unwrap(OraclePreparedStatement.class);
		
		String str = (String) arg1;
		int index  = arg0.getParameterIndex();

		// 空白埋めするために、setStringではなく下記を呼ぶ
		ops.setFixedCHAR(index, str);
	}

	@Override
	public Object valueOf(String arg0) {
		return arg0;
	}
}
