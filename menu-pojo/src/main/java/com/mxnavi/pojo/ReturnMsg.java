package com.mxnavi.pojo;

import java.io.Serializable;

public enum ReturnMsg implements Serializable{
	SUCCESS("0", "�����ɹ�"),
	EXCEPTION1("10001", "δ֪�쳣"),
	EXCEPTION2("10002", "����ʧ��"),
	EXCEPTION3("10003", "�ϴ�ʧ��"),
	EXCEPTION4("10004", "�˺Ż��������"),
	EXCEPTION5("10005", "�Զ����쳣"),
	ERROR("-1", "ʧ��");
	
	private String code;
	private String msg;
	
	private ReturnMsg (String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}

