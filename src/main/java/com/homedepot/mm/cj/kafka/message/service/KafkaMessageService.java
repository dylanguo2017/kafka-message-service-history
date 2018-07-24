package com.homedepot.mm.cj.kafka.message.service;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

public interface KafkaMessageService {
	
	public KafkaMessageWraper getFlagDetail();
	public KafkaMessageWraper getFlagDetailBySrcCd(String src_cd);
	public void updateFlagDetail(KafkaMessageWraper eccParamWraper);
}
