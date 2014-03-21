package com.ibatis.quickstart.sample.common;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.ibatis.quickstart.sample.common.ConfigReader;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ConfigReaderTest {
	
	/**
	 * SqlMapConfig.xmlからSqlMapClientインスタンスの生成の確認
	 * 
	 * @throws IOException
	 */
	@Test
	public void getSqlMapInstance_is_success() throws IOException {
		SqlMapClient sqlMapInstance = ConfigReader.getSqlMapInstance();
		assertNotNull(sqlMapInstance);
	}
}
