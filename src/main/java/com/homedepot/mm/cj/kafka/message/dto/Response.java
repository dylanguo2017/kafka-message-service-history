package com.homedepot.mm.cj.kafka.message.dto;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private String statusDesc;
	private int status;
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Response [statusDesc=" + statusDesc + ", status=" + status + "]";
	}

}
