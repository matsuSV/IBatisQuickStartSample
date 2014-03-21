package com.ibatis.quickstart.sample.common;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.quickstart.sample.util.LogProvider;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * SQL文が記載された設定ファイルをリソースとして定義している設定ファイルを読み込むクラス
 */
public class ConfigReader {

	private static final String CONFIG_PATH = "SqlMapConfig.xml";

	/**
	 * マッピング対象となるSQL文を読み込み、SqlMapClientインスタンスを返却する処理
	 * 
	 * @return smc : SqlMapClientインスタンス
	 * @throws IOException 
	 */
	public static SqlMapClient getSqlMapInstance() throws IOException {

		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(CONFIG_PATH);
		} catch( IOException ioe ) {
			LogProvider.error(CONFIG_PATH + " の読み込みで例外が発生しました。", ioe); 
			throw new IOException(ioe);
		}

		SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		return sqlMapClient;
	}
}
