package com.homedepot.mm.cj.kafka.message.dao;
//package com.homedepot.mm.cj.ecc.param.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.jdbc.core.RowMapper;
//import com.homedepot.mm.cj.ecc.param.dto.EccQaflagDto;
//
//public class ParamFlagMapper implements RowMapper<EccQaflagDto> {
//	private static final Logger LOGGER = LogManager.getLogger(ParamFlagMapper.class);
//
//	@Override
//	public EccQaflagDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//		LOGGER.debug("Start ParamFlagMapper: mapRow()");
//		EccQaflagDto c = new EccQaflagDto();
//		c.setClient(rs.getString(1));
//		c.setFlag(rs.getString(2));
//		c.setSrc_cd(rs.getInt(3));
//		c.setUpd_Ts(rs.getTimestamp(4));
//		LOGGER.debug("ParamFlagMapper: mapRow() End");
//		return c;
//	}
//
//
//}
