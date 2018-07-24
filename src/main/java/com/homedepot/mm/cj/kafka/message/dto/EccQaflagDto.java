package com.homedepot.mm.cj.kafka.message.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class EccQaflagDto {
	private String client;
	private String flag;
	private int src_cd;
	private Timestamp upd_Ts;	
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getFlag() {
		
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
		
	}
	public int getSrc_cd() {
		return src_cd;
	}
	public void setSrc_cd(int src_cd) {
		this.src_cd = src_cd;
	}
	public Timestamp getUpd_Ts() {
		return upd_Ts;
	}
	public void setUpd_Ts(Timestamp upd_Ts) {
		this.upd_Ts = upd_Ts;
	}
	@Override
	public String toString() {
		return "EccQaflagDto [client=" + client + ", flag=" + flag + ", src_cd=" + src_cd + ", upd_Ts=" + upd_Ts + "]";
	}
	
}
