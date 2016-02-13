package com.palette.busi.project.tms.core.dao;

import java.util.List;
import java.math.BigDecimal;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.palette.busi.project.tms.core.entity.CdDistrict;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class CdDistrictSqlProvider extends BaseSqlProvider {

	public String update(CdDistrict record) {
		BEGIN();
        UPDATE("cd_district");
        if (record.getCdDistrictId() != null) {
            SET("CD_DISTRICT_ID = #{cdDistrictId}");
        }
        if (record.getDistrictCode() != null) {
            SET("DISTRICT_CODE = #{districtCode}");
        }
        if (record.getDistrictName() != null) {
            SET("DISTRICT_NAME = #{districtName}");
        }
        if (record.getDistrictEnglishName() != null) {
            SET("DISTRICT_ENGLISH_NAME = #{districtEnglishName}");
        }
        if (record.getCityCode() != null) {
            SET("CITY_CODE = #{cityCode}");
        }
        if (record.getIsRemoteArea() != null) {
            SET("IS_REMOTE_AREA = #{isRemoteArea}");
        }
        if (record.getCompanyCode() != null) {
            SET("COMPANY_CODE = #{companyCode}");
        }
        if (record.getRecordVersion() != null) {
            SET("RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCreateUserCode() != null) {
            SET("CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            SET("CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateTimeZone() != null) {
            SET("CREATE_TIME_ZONE = #{createTimeZone}");
        }
        if (record.getUpdateUserCode() != null) {
            SET("UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            SET("UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateTimeZone() != null) {
            SET("UPDATE_TIME_ZONE = #{updateTimeZone}");
        }

        WHERE("cd_district_id = #{cdDistrictId}");

        return SQL();
	}

    public String selectAllByRecord(CdDistrict record) {
        BEGIN();
        SELECT("*");
        FROM("cd_district");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getCdDistrictId() != null) {
            stringBuffer.append(" AND CD_DISTRICT_ID = #{cdDistrictId}");
        }
        if (record.getDistrictCode() != null) {
            stringBuffer.append(" AND DISTRICT_CODE = #{districtCode}");
        }
        if (record.getDistrictName() != null) {
            stringBuffer.append(" AND DISTRICT_NAME = #{districtName}");
        }
        if (record.getDistrictEnglishName() != null) {
            stringBuffer.append(" AND DISTRICT_ENGLISH_NAME = #{districtEnglishName}");
        }
        if (record.getCityCode() != null) {
            stringBuffer.append(" AND CITY_CODE = #{cityCode}");
        }
        if (record.getIsRemoteArea() != null) {
            stringBuffer.append(" AND IS_REMOTE_AREA = #{isRemoteArea}");
        }
        if (record.getCompanyCode() != null) {
            stringBuffer.append(" AND COMPANY_CODE = #{companyCode}");
        }
        if (record.getRecordVersion() != null) {
            stringBuffer.append(" AND RECORD_VERSION = #{recordVersion}");
        }
        if (record.getCreateUserCode() != null) {
            stringBuffer.append(" AND CREATE_USER_CODE = #{createUserCode}");
        }
        if (record.getCreateDateTime() != null) {
            stringBuffer.append(" AND CREATE_DATE_TIME = #{createDateTime}");
        }
        if (record.getCreateTimeZone() != null) {
            stringBuffer.append(" AND CREATE_TIME_ZONE = #{createTimeZone}");
        }
        if (record.getUpdateUserCode() != null) {
            stringBuffer.append(" AND UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            stringBuffer.append(" AND UPDATE_DATE_TIME = #{updateDateTime}");
        }
        if (record.getUpdateTimeZone() != null) {
            stringBuffer.append(" AND UPDATE_TIME_ZONE = #{updateTimeZone}");
        }

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
