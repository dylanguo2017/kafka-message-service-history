package com.homedepot.mm.cj.kafka.message.dto;

import org.springframework.stereotype.Component;

@Component
public class KafkaMessageResponse {
	private String client;
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "EccParamResponse [client=" + client + ", flag=" + flag + "]";
	}



}
