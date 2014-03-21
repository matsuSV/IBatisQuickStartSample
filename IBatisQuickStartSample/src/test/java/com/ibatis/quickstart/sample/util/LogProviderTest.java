package com.ibatis.quickstart.sample.util;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibatis.quickstart.sample.util.LogProvider;

public class LogProviderTest {
	
	private static PrintStream saved;
	private static ByteArrayOutputStream actual;
	
	@BeforeClass
	public static void beforeClass() {
		saved = System.out;
		actual = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(actual)));
	}
	
	@AfterClass
	public static void afterClass() {
		System.setOut(saved);
	}
	
	@Before
	public void setUp() {
		actual.reset();
	}

	/**
	 * outputResult関数の出力メッセージの確認
	 */
	@Test
	public void outputResult_is_success() {
		List<LogProviderTest> list = new ArrayList<LogProviderTest>();
		list.add(new LogProviderTest());
		LogProvider.outputResult(list);
		System.out.flush();
		verify("outputResult_is_success");
	}
	
	/**
	 * info関数の出力メッセージの確認
	 */
	@Test
	public void info_is_success() {
		String testMessage = "info_is_success";
		LogProvider.info(testMessage);
		System.out.flush();
		verify(testMessage);
	}

	/**
	 * error関数の出力メッセージの確認
	 */
	@Test
	public void error_is_success() {
		String testMessage = "error_is_success";
		LogProvider.error(testMessage, new Exception());
		System.out.flush();
		verify(testMessage);
	}

	public String toString() {
		return "outputResult_is_success";
	}
	
	/**
	 * 出力結果の成否を判定する処理
	 * 
	 * @param message : 出力予想メッセージ
	 */
	private synchronized void verify(String message) {
		Pattern pattern = Pattern.compile(message);
		Matcher matcher = pattern.matcher(actual.toString());
		assertTrue(matcher.find());
	}
}
