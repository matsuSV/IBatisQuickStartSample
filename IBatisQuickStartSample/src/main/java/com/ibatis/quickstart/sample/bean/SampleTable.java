package com.ibatis.quickstart.sample.bean;

import java.util.Date;

/**
 * Employeeテーブルの値を格納するクラス
 *
 */
public class SampleTable {

	// 従業員番号
	private String empno;
	
	// 従業員名
	private String fullname;
	
	// 性別
	private String sex;
	
	// 誕生日
	private Date birthdate;
	
	// 給料
	private Double salay; 


	/* iBatisがSQL結果をエンティティに格納する際に呼び出すsetter */

	/**
	 * 従業員番号 設定。<br>
	 * @param  従業員番号
	 */
	public void setEmpno(String empno) {
		this.empno = empno;
	}

	/**
	 * 従業員名 設定。<br>
	 * @param  従業員名
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * 性 設定。<br>
	 * @param  性
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 生年月日 設定。<br>
	 * @param  生年月日
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * 給料 設定。<br>
	 * @param  給料
	 */
	public void setSalay(Double salay) {
		this.salay = salay;
	}

	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();

		sb.append("従業員番号 = ");
		sb.append(this.empno);
		sb.append("\n");

		sb.append("従業員名 = ");
		sb.append(this.fullname);
		sb.append("\n");
		
		sb.append("性別 = ");
		sb.append(this.sex);
		sb.append("\n");
		
		sb.append("誕生日 = ");
		sb.append(this.birthdate);
		sb.append("\n");
		
		sb.append("給料 = ");
		sb.append(this.salay);
		sb.append("\n");

		return sb.toString();
	}

}
