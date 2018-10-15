package com.homedepot.mm.cj.kafka.message.service;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWrapper;

public interface KafkaMessageService {
	
	public KafkaMessageWrapper getFlagDetail();
	public KafkaMessageWrapper getFlagDetailBySrcCd(String src_cd);
	public void updateFlagDetail(KafkaMessageWrapper eccParamWrapper);
}
