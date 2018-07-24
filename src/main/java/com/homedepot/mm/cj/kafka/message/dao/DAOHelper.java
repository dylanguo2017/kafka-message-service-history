package com.homedepot.mm.cj.kafka.message.dao;

public class DAOHelper {

	public static final String SELECT_FLAG_PARAM_SQL = " select * from QA_FLAG ";
	public static final String UPDATE_FLAG_PARAM_SQL_BY_CLIENT = " update QA_FLAG set flag = ? , upd_ts = ? where client = ? ";
	public static final String SELECT_FLAG_PARAM_SQL_BY_SRCCD = " select * from QA_FLAG where src_cd like ? ";


}
