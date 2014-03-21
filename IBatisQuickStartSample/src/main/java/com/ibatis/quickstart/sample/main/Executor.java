package com.ibatis.quickstart.sample.main;

import java.io.IOException;
import java.sql.SQLException;

import com.ibatis.quickstart.sample.bean.SampleTable;
import com.ibatis.quickstart.sample.query.Inserter;
import com.ibatis.quickstart.sample.query.Selector;
import com.ibatis.quickstart.sample.util.LogProvider;

/**
 * main関数
 *
 */
public class Executor {
	public static void main(String[] args) {

		try {
			Selector selector = new Selector();
			selector.execute(SampleTable.class, "ibatis.sample.select_QT_SAMPLE_170_EMPLOYEE", "qt_Sample_100%");
			
//			Inserter inserter = new Inserter();
//			inserter.run("ibatis.sample.insert_QT_SAMPLE_170_EMPLOYEE");
			
			
			
			
		} catch (SQLException e) {
			LogProvider.error("", e);
		} catch (IOException e) {
			LogProvider.error("", e);
		}
	}
}
