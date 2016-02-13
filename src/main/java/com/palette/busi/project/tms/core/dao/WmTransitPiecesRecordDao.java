package com.palette.busi.project.tms.core.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.palette.busi.project.tms.core.base.dao.impl.BaseDaoImpl;
import com.palette.busi.project.tms.core.base.BaseException;
import com.palette.busi.project.tms.core.entity.WmTransitPiecesRecord;
import com.palette.busi.project.tms.core.dao.WmTransitPiecesRecordIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class WmTransitPiecesRecordDao extends BaseDaoImpl {
	
	public WmTransitPiecesRecord updateWmTransitPiecesRecord(WmTransitPiecesRecord wmTransitPiecesRecord, String user, String programId) throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		wmTransitPiecesRecord.setUpdateDateTime(getCurrentGMTDate());
		wmTransitPiecesRecord.setUpdateUserCode(user);
		mapper.updateWmTransitPiecesRecord(wmTransitPiecesRecord);
		return wmTransitPiecesRecord;
	}
	
	public WmTransitPiecesRecord insertWmTransitPiecesRecord(WmTransitPiecesRecord wmTransitPiecesRecord, String user, String programId) throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		wmTransitPiecesRecord.setCreateDateTime(getCurrentGMTDate());
		wmTransitPiecesRecord.setCreateUserCode(user);
		wmTransitPiecesRecord.setUpdateDateTime(getCurrentGMTDate());
		wmTransitPiecesRecord.setUpdateUserCode(user);
		mapper.insertWmTransitPiecesRecord(wmTransitPiecesRecord);
		if(wmTransitPiecesRecord.getWmTransitPiecesRecordId() == null){
			wmTransitPiecesRecord.setWmTransitPiecesRecordId(getLastPk());
		}
		return wmTransitPiecesRecord;
	}
	
	public WmTransitPiecesRecord selectWmTransitPiecesRecordById(Integer wmTransitPiecesRecordId) throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		return mapper.selectWmTransitPiecesRecordById(wmTransitPiecesRecordId);
	}
	
	public Integer deleteWmTransitPiecesRecord(Integer wmTransitPiecesRecordId) throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		return mapper.deleteWmTransitPiecesRecord(wmTransitPiecesRecordId);
	}
	
	public List<WmTransitPiecesRecord> selectAllWmTransitPiecesRecord() throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		List<WmTransitPiecesRecord> allWmTransitPiecesRecord = mapper.selectAllWmTransitPiecesRecord();
		return allWmTransitPiecesRecord;
	}
	
	public List<WmTransitPiecesRecord> selectAllByRecord(WmTransitPiecesRecord wmTransitPiecesRecord) throws BaseException {
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		return mapper.selectAllByRecord(wmTransitPiecesRecord);
	}
	
	public PageInfo selectPageByRecord(WmTransitPiecesRecord wmTransitPiecesRecord) throws BaseException {
		PageModel pageModel = wmTransitPiecesRecord.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		WmTransitPiecesRecordIntf mapper = this.getSqlSessionTemplate().getMapper(WmTransitPiecesRecordIntf.class);
		mapper.selectAllByRecord(wmTransitPiecesRecord);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public WmTransitPiecesRecord selectOneByRecord(WmTransitPiecesRecord wmTransitPiecesRecord) throws BaseException {
		List<WmTransitPiecesRecord> resultList = selectAllByRecord(wmTransitPiecesRecord);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public WmTransitPiecesRecord saveWmTransitPiecesRecord(WmTransitPiecesRecord wmTransitPiecesRecord, String user, String programId) throws BaseException {
		if(wmTransitPiecesRecord.getWmTransitPiecesRecordId() == null){
			wmTransitPiecesRecord = insertWmTransitPiecesRecord(wmTransitPiecesRecord, user, programId);
		}else{
			wmTransitPiecesRecord = updateWmTransitPiecesRecord(wmTransitPiecesRecord, user, programId);
		}
		return wmTransitPiecesRecord;
	}
	
	private Date getCurrentGMTDate() {
		try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
	        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return dateTimeFormat.parse(dateFormat.format(new Date()));
		} catch (Exception e) {
			throw new BaseException(e.getMessage());
		}
    }
}