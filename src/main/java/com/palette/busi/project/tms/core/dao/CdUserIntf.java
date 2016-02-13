package com.palette.busi.project.tms.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.ResultType;

import com.palette.busi.project.tms.core.entity.CdUser;
import com.palette.busi.project.tms.core.dao.CdUserSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface CdUserIntf extends BaseMybatisMapper {


	@Select("SELECT  CD_USER_ID  AS cdUserId, USER_NAME  AS userName, FULL_NAME  AS fullName, GENDER  AS gender, MEMO  AS memo, IS_ACTIVE  AS isActive, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM cd_user WHERE cd_user_id=#{cdUserId}")
	public CdUser selectCdUserById(@Param("cdUserId") int cdUserId);
	
	@Select("SELECT  CD_USER_ID  AS cdUserId, USER_NAME  AS userName, FULL_NAME  AS fullName, GENDER  AS gender, MEMO  AS memo, IS_ACTIVE  AS isActive, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM cd_user")
	public List<CdUser> selectAllCdUser();
	
	@Insert("insert into cd_user ( CD_USER_ID, USER_NAME, FULL_NAME, GENDER, MEMO, IS_ACTIVE, COMPANY_CODE, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{cdUserId},#{userName},#{fullName},#{gender},#{memo},#{isActive},#{companyCode},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertCdUser(CdUser cdUser);

	@UpdateProvider(type=CdUserSqlProvider.class, method="update")
	public int updateCdUser(CdUser cdUser);
	
	@Delete("delete from cd_user where cd_user_id = #{cdUserId}")
	public int deleteCdUser(@Param("cdUserId") int cdUserId);

    @SelectProvider(type=CdUserSqlProvider.class, method="selectAllByRecord")
    @ResultType(CdUser.class)
    public List<CdUser> selectAllByRecord(CdUser record);
    
}