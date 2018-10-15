package com.homedepot.mm.cj.kafka.message.dto;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class KafkaMessageWrapper extends Response{

	@Override
	public String toString() {
		return "EccParamWraper [eccParamResponse=" + eccParamResponse + "]";
	}

	private List<KafkaMessageResponse> eccParamResponse;

	public List<KafkaMessageResponse> getEccParamResponse() {
		return eccParamResponse;
	}

	public void setEccParamResponse(List<KafkaMessageResponse> eccParamResponse) {
		this.eccParamResponse = eccParamResponse;
	}
	
/*	private List<EccQaflagDto> eccFlagDtoList;

	public List<EccQaflagDto> getEccFlagDtoList() {
		return eccFlagDtoList;
	}

	public void setEccFlagDtoList(List<EccQaflagDto> eccFlagDtoList) {
		this.eccFlagDtoList = eccFlagDtoList;
	}*/
}
