package com.homedepot.mm.cj.kafka.message.dao;
//package com.homedepot.mm.cj.ecc.param.dao;
//
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import com.homedepot.mm.cj.ecc.param.dto.EccQaflagDto;
//
//@Component
//public class ECCParamDao {
//	private static final Logger LOGGER = LogManager.getLogger(ECCParamDao.class);
//
//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	public String dbPing() throws SQLException {
//		LOGGER.debug("dbPing");
//		return jdbc.queryForObject("select current_timestamp from dual", Date.class).toString();
//	}
//
//	public List<EccQaflagDto> getFlag() throws SQLException {
//		LOGGER.info("ECCParamDao getFlag ");
//		long startTime = System.currentTimeMillis();
//		List<EccQaflagDto> paramDtlsList = jdbc.query(DAOHelper.SELECT_FLAG_PARAM_SQL, new ParamFlagMapper());
//		long responseTime = System.currentTimeMillis() - startTime;
//		LOGGER.info("Response Time to fetch all the Param list Flags = " + responseTime);
//		return paramDtlsList;
//	}
//	
//	public List<EccQaflagDto> getFlagBySrcCd(String src_cd) throws SQLException {
//		LOGGER.info("ECCParamDao getFlagBySrcCd() src_cd is  "+src_cd);
//		long startTime = System.currentTimeMillis();
//		List<EccQaflagDto> paramDtls =jdbc.query(DAOHelper.SELECT_FLAG_PARAM_SQL_BY_SRCCD, new Object[]{src_cd}, new ParamFlagMapper());
//		long responseTime = System.currentTimeMillis() - startTime;
//		LOGGER.info("Response Time  to fetch the Param Flag By SrcCd= " + responseTime);
//		return paramDtls;
//	}
//
//	public void updateParamFlag(List<EccQaflagDto> flagDtoList) throws SQLException {	
//		LOGGER.info("ECCParamDao updateParamFlag List size "+flagDtoList.size());
//		jdbc.batchUpdate(DAOHelper.UPDATE_FLAG_PARAM_SQL_BY_CLIENT, new BatchPreparedStatementSetter() {
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				//for (i = 1; i <= flagDtoList.size(); i++) {
//				EccQaflagDto flagDto = flagDtoList.get(i);
//				ps.setString(1, flagDto.getFlag());
//				ps.setTimestamp(2, flagDto.getUpd_Ts());
//				ps.setString(3, flagDto.getClient());
//				//}
//			}
//			public int getBatchSize() {
//				return flagDtoList.size();
//			}
//		});		
//	}
//
//
//}
