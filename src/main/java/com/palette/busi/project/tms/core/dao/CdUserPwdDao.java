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
import com.palette.busi.project.tms.core.entity.CdUserPwd;
import com.palette.busi.project.tms.core.dao.CdUserPwdIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class CdUserPwdDao extends BaseDaoImpl {
	
	public CdUserPwd updateCdUserPwd(CdUserPwd cdUserPwd, String user, String programId) throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		cdUserPwd.setUpdateDateTime(getCurrentGMTDate());
		cdUserPwd.setUpdateUserCode(user);
		mapper.updateCdUserPwd(cdUserPwd);
		return cdUserPwd;
	}
	
	public CdUserPwd insertCdUserPwd(CdUserPwd cdUserPwd, String user, String programId) throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		cdUserPwd.setCreateDateTime(getCurrentGMTDate());
		cdUserPwd.setCreateUserCode(user);
		cdUserPwd.setUpdateDateTime(getCurrentGMTDate());
		cdUserPwd.setUpdateUserCode(user);
		mapper.insertCdUserPwd(cdUserPwd);
		if(cdUserPwd.getCdUserPwdId() == null){
			cdUserPwd.setCdUserPwdId(getLastPk());
		}
		return cdUserPwd;
	}
	
	public CdUserPwd selectCdUserPwdById(Integer cdUserPwdId) throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		return mapper.selectCdUserPwdById(cdUserPwdId);
	}
	
	public Integer deleteCdUserPwd(Integer cdUserPwdId) throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		return mapper.deleteCdUserPwd(cdUserPwdId);
	}
	
	public List<CdUserPwd> selectAllCdUserPwd() throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		List<CdUserPwd> allCdUserPwd = mapper.selectAllCdUserPwd();
		return allCdUserPwd;
	}
	
	public List<CdUserPwd> selectAllByRecord(CdUserPwd cdUserPwd) throws BaseException {
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		return mapper.selectAllByRecord(cdUserPwd);
	}
	
	public PageInfo selectPageByRecord(CdUserPwd cdUserPwd) throws BaseException {
		PageModel pageModel = cdUserPwd.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		CdUserPwdIntf mapper = this.getSqlSessionTemplate().getMapper(CdUserPwdIntf.class);
		mapper.selectAllByRecord(cdUserPwd);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public CdUserPwd selectOneByRecord(CdUserPwd cdUserPwd) throws BaseException {
		List<CdUserPwd> resultList = selectAllByRecord(cdUserPwd);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public CdUserPwd saveCdUserPwd(CdUserPwd cdUserPwd, String user, String programId) throws BaseException {
		if(cdUserPwd.getCdUserPwdId() == null){
			cdUserPwd = insertCdUserPwd(cdUserPwd, user, programId);
		}else{
			cdUserPwd = updateCdUserPwd(cdUserPwd, user, programId);
		}
		return cdUserPwd;
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