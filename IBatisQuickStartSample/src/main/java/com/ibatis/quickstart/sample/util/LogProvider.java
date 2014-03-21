package com.ibatis.quickstart.sample.util;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * ログ出力を提供するクラス
 * 
 * 様々なクラスでLoggerクラスを保持させず、本クラスに委譲させる。
 */
public class LogProvider {
	
	private static Logger log = Logger.getLogger(LogProvider.class);
	
	/**
	 * select関数を発行した結果セットを引数として受け取り、
	 * 結果行のデータをログ出力する処理。
	 * 
	 * @param resultLists : 結果セット
	 */
	public static <T> void outputResult(List<T> resultLists) {
		for( T result : resultLists ) {
			log.info(result.toString());
		}
	}

	/**
	 * infoログ出力関数
	 * 
	 * @param message : 出力メッセージ
	 */
	public static void info(String message) {
		log.info(message);
	}

	/**
	 * errorログ出力処理
	 * 
	 * @param message : 出力メッセージ
	 * @param e       : 例外インスタンス
	 */
	public static void error(String message, Exception e) {
		log.error(message, e);
	}
}
