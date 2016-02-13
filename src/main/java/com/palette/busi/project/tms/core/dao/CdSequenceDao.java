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
import com.palette.busi.project.tms.core.entity.CdSequence;
import com.palette.busi.project.tms.core.dao.CdSequenceIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdSequenceDao extends BaseDaoImpl {
	
	public CdSequence updateCdSequence(CdSequence cdSequence, String user, String programId) throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		cdSequence.setUpdateDateTime(getCurrentGMTDate());
		cdSequence.setUpdateUserCode(user);
		mapper.updateCdSequence(cdSequence);
		return cdSequence;
	}
	
	public CdSequence insertCdSequence(CdSequence cdSequence, String user, String programId) throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		cdSequence.setCreateDateTime(getCurrentGMTDate());
		cdSequence.setCreateUserCode(user);
		cdSequence.setUpdateDateTime(getCurrentGMTDate());
		cdSequence.setUpdateUserCode(user);
		mapper.insertCdSequence(cdSequence);
		if(cdSequence.getCdSequenceId() == null){
			cdSequence.setCdSequenceId(getLastPk());
		}
		return cdSequence;
	}
	
	public CdSequence selectCdSequenceById(Integer cdSequenceId) throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		return mapper.selectCdSequenceById(cdSequenceId);
	}
	
	public Integer deleteCdSequence(Integer cdSequenceId) throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		return mapper.deleteCdSequence(cdSequenceId);
	}
	
	public List<CdSequence> selectAllCdSequence() throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		List<CdSequence> allCdSequence = mapper.selectAllCdSequence();
		return allCdSequence;
	}
	
	public List<CdSequence> selectAllByRecord(CdSequence cdSequence) throws BaseException {
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		return mapper.selectAllByRecord(cdSequence);
	}
	
	public PageInfo selectPageByRecord(CdSequence cdSequence) throws BaseException {
		PageModel pageModel = cdSequence.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdSequenceIntf mapper = this.getSqlSessionTemplate().getMapper(CdSequenceIntf.class);
		mapper.selectAllByRecord(cdSequence);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdSequence selectOneByRecord(CdSequence cdSequence) throws BaseException {
		List<CdSequence> resultList = selectAllByRecord(cdSequence);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdSequence saveCdSequence(CdSequence cdSequence, String user, String programId) throws BaseException {
		if(cdSequence.getCdSequenceId() == null){
			cdSequence = insertCdSequence(cdSequence, user, programId);
		}else{
			cdSequence = updateCdSequence(cdSequence, user, programId);
		}
		return cdSequence;
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