package com.lov2code.springdemo.dto;

public class RequestDTO {
	private String respCode = "0000";
	private String respMsg = "Request was successfull";
	private String customerId;
	private Integer fmtUserId;
	private String hash;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Integer getFmtUserId() {
		return fmtUserId;
	}
	public void setFmtUserId(Integer fmtUserId) {
		this.fmtUserId = fmtUserId;
	}
	@Override
	public String toString() {
		return "RequestDTO [respCode=" + respCode + ", respMsg=" + respMsg + ", customerId=" + customerId
				+ ", fmtUserId=" + fmtUserId + ", hash=" + hash + "]";
	}
	
}
