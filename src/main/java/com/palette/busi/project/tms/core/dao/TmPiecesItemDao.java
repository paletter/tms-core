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
import com.palette.busi.project.tms.core.entity.TmPiecesItem;
import com.palette.busi.project.tms.core.dao.TmPiecesItemIntf;
import com.palette.busi.project.tms.core.page.Page;
import com.palette.busi.project.tms.core.page.PageFormat;
import com.palette.busi.project.tms.core.page.PageHelper;
import com.palette.busi.project.tms.core.page.PageInfo;
import com.palette.busi.project.tms.core.page.PageModel;

@Component
public class TmPiecesItemDao extends BaseDaoImpl {
	
	public TmPiecesItem updateTmPiecesItem(TmPiecesItem tmPiecesItem, String user, String programId) throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		tmPiecesItem.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesItem.setUpdateUserCode(user);
		mapper.updateTmPiecesItem(tmPiecesItem);
		return tmPiecesItem;
	}
	
	public TmPiecesItem insertTmPiecesItem(TmPiecesItem tmPiecesItem, String user, String programId) throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		tmPiecesItem.setCreateDateTime(getCurrentGMTDate());
		tmPiecesItem.setCreateUserCode(user);
		tmPiecesItem.setUpdateDateTime(getCurrentGMTDate());
		tmPiecesItem.setUpdateUserCode(user);
		mapper.insertTmPiecesItem(tmPiecesItem);
		if(tmPiecesItem.getTmPiecesItemId() == null){
			tmPiecesItem.setTmPiecesItemId(getLastPk());
		}
		return tmPiecesItem;
	}
	
	public TmPiecesItem selectTmPiecesItemById(Integer tmPiecesItemId) throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.selectTmPiecesItemById(tmPiecesItemId);
	}
	
	public Integer deleteTmPiecesItem(Integer tmPiecesItemId) throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.deleteTmPiecesItem(tmPiecesItemId);
	}
	
	public List<TmPiecesItem> selectAllTmPiecesItem() throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		List<TmPiecesItem> allTmPiecesItem = mapper.selectAllTmPiecesItem();
		return allTmPiecesItem;
	}
	
	public List<TmPiecesItem> selectAllByRecord(TmPiecesItem tmPiecesItem) throws BaseException {
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		return mapper.selectAllByRecord(tmPiecesItem);
	}
	
	public PageInfo selectPageByRecord(TmPiecesItem tmPiecesItem) throws BaseException {
		PageModel pageModel = tmPiecesItem.getPageInfo();
		PageHelper.startPage(pageModel.getPageNum(), pageModel.getPageSize());
		TmPiecesItemIntf mapper = this.getSqlSessionTemplate().getMapper(TmPiecesItemIntf.class);
		mapper.selectAllByRecord(tmPiecesItem);
		Page page = PageHelper.endPage();
		return PageFormat.dataFormat(page);
	}
	
	public TmPiecesItem selectOneByRecord(TmPiecesItem tmPiecesItem) throws BaseException {
		List<TmPiecesItem> resultList = selectAllByRecord(tmPiecesItem);
		if(resultList.size() == 1){
			return resultList.get(0); 
		}else if(resultList.size() == 0){
			return null;
		}else{
			throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + resultList.size());
		}
	}
	
	public TmPiecesItem saveTmPiecesItem(TmPiecesItem tmPiecesItem, String user, String programId) throws BaseException {
		if(tmPiecesItem.getTmPiecesItemId() == null){
			tmPiecesItem = insertTmPiecesItem(tmPiecesItem, user, programId);
		}else{
			tmPiecesItem = updateTmPiecesItem(tmPiecesItem, user, programId);
		}
		return tmPiecesItem;
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