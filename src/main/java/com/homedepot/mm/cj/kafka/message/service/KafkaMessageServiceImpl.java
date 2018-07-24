package com.homedepot.mm.cj.kafka.message.service;
//package com.homedepot.mm.cj.ecc.param.service;
//
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.homedepot.mm.cj.ecc.param.dao.ECCParamDao;
//import com.homedepot.mm.cj.ecc.param.dto.EccParamResponse;
//import com.homedepot.mm.cj.ecc.param.dto.EccParamWraper;
//import com.homedepot.mm.cj.ecc.param.dto.EccQaflagDto;
//
//@Service
//public class EccParamServiceImpl implements EccParamService {
//	@Autowired
//	ECCParamDao eCCParamDao;
//	
//	private static final Logger LOGGER = LogManager.getLogger(EccParamServiceImpl.class);
//
//
//	@Override
//	public EccParamWraper getFlagDetail() {
//		LOGGER.info("EccParamServiceImpl getFlagDetail :: BEGIN ");
//		List<EccQaflagDto> eccQaflagDtoList = new ArrayList<EccQaflagDto>();
//		EccParamResponse eccParamResponse=null;
//		List<EccParamResponse> eccParamResponseList=new ArrayList<EccParamResponse>();
//		EccParamWraper eccParamResponseWraper=new EccParamWraper();
//		try {
//			eccQaflagDtoList = eCCParamDao.getFlag();
//			for(EccQaflagDto eccFlag: eccQaflagDtoList){
//				eccParamResponse=new EccParamResponse();
//				eccParamResponse.setClient(eccFlag.getClient());
//				eccParamResponse.setFlag(Boolean.valueOf(eccFlag.getFlag()));
//				eccParamResponseList.add(eccParamResponse);
//			}
//			eccParamResponseWraper.setEccParamResponse(eccParamResponseList);			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		LOGGER.info("EccParamServiceImpl getFlagDetail :: END "+eccParamResponseWraper.toString());
//
//		return eccParamResponseWraper;
//
//	}
//	
//	@Override
//	public EccParamWraper getFlagDetailBySrcCd(String src_cd) {
//		List<EccQaflagDto> eccQaflagDtoList = new ArrayList<EccQaflagDto>();
//		EccParamResponse eccParamResponse=null;
//		List<EccParamResponse> eccParamResponseList=new ArrayList<EccParamResponse>();
//		EccParamWraper eccParamResponseWraper=new EccParamWraper();
//		try {
//			eccQaflagDtoList = eCCParamDao.getFlagBySrcCd(src_cd);
//			for(EccQaflagDto eccFlag: eccQaflagDtoList){
//				eccParamResponse=new EccParamResponse();
//				eccParamResponse.setClient(eccFlag.getClient());
//				eccParamResponse.setFlag(Boolean.valueOf(eccFlag.getFlag()));
//				eccParamResponseList.add(eccParamResponse);
//			}
//			eccParamResponseWraper.setEccParamResponse(eccParamResponseList);
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return eccParamResponseWraper;
//
//	}
///*	public EccParamWraper getFlagDetail() {
//		List<EccQaflagDto> eccQaflagDtoList = new ArrayList<EccQaflagDto>();
//		EccParamWraper eccParamWraper=new EccParamWraper();
//
//		try {
//			eccQaflagDtoList = eCCParamDao.getFlag();
//			
//			eccParamWraper.setEccFlagDtoList(eccQaflagDtoList);
//
//		} */
///*		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return eccParamWraper;
//	}*/
//	
//	@Override
//	public void updateFlagDetail(EccParamWraper eccParamWraper){
//		List<EccParamResponse> eccQaFlagList=new ArrayList<EccParamResponse>();
//		List<EccQaflagDto> eccQaflagDtoList = new ArrayList<EccQaflagDto>();
//		EccQaflagDto eccQaflagDto=null;
//		eccQaFlagList=eccParamWraper.getEccParamResponse();
//		for(EccParamResponse param : eccQaFlagList){
//			eccQaflagDto=new EccQaflagDto();
//			eccQaflagDto.setClient(param.getClient());
//			eccQaflagDto.setFlag(String.valueOf(param.isFlag()));
//			eccQaflagDto.setUpd_Ts(new Timestamp(System.currentTimeMillis()));
//			eccQaflagDtoList.add(eccQaflagDto);
//		}
//		try {
//			eCCParamDao.updateParamFlag(eccQaflagDtoList);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//}
