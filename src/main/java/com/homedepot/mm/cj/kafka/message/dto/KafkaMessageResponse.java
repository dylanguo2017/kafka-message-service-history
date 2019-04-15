package com.homedepot.mm.cj.kafka.message.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessageResponse {

	private String statusDesc;
	private int status;

}
