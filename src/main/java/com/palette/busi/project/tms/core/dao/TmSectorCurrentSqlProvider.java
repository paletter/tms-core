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

import com.palette.busi.project.tms.core.entity.TmSectorCurrent;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class TmSectorCurrentSqlProvider extends BaseSqlProvider {

	public String update(TmSectorCurrent record) {
		BEGIN();
        UPDATE("tm_sector_current");
        if (record.getTmSectorCurrentId() != null) {
            SET("TM_SECTOR_CURRENT_ID = #{tmSectorCurrentId}");
        }
        if (record.getTmSectorId() != null) {
            SET("TM_SECTOR_ID = #{tmSectorId}");
        }
        if (record.getSectorCode() != null) {
            SET("SECTOR_CODE = #{sectorCode}");
        }
        if (record.getActionCode() != null) {
            SET("ACTION_CODE = #{actionCode}");
        }
        if (record.getMemo() != null) {
            SET("MEMO = #{memo}");
        }
        if (record.getActionPlace() != null) {
            SET("ACTION_PLACE = #{actionPlace}");
        }
        if (record.getActionDateTime() != null) {
            SET("ACTION_DATE_TIME = #{actionDateTime}");
        }
        if (record.getActionUserName() != null) {
            SET("ACTION_USER_NAME = #{actionUserName}");
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
        if (record.getUpdateUserCode() != null) {
            SET("UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            SET("UPDATE_DATE_TIME = #{updateDateTime}");
        }

        WHERE("tm_sector_current_id = #{tmSectorCurrentId}");

        return SQL();
	}

    public String selectAllByRecord(TmSectorCurrent record) {
        BEGIN();
        SELECT("*");
        FROM("tm_sector_current");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getTmSectorCurrentId() != null) {
            stringBuffer.append(" AND TM_SECTOR_CURRENT_ID = #{tmSectorCurrentId}");
        }
        if (record.getTmSectorId() != null) {
            stringBuffer.append(" AND TM_SECTOR_ID = #{tmSectorId}");
        }
        if (record.getSectorCode() != null) {
            stringBuffer.append(" AND SECTOR_CODE = #{sectorCode}");
        }
        if (record.getActionCode() != null) {
            stringBuffer.append(" AND ACTION_CODE = #{actionCode}");
        }
        if (record.getMemo() != null) {
            stringBuffer.append(" AND MEMO = #{memo}");
        }
        if (record.getActionPlace() != null) {
            stringBuffer.append(" AND ACTION_PLACE = #{actionPlace}");
        }
        if (record.getActionDateTime() != null) {
            stringBuffer.append(" AND ACTION_DATE_TIME = #{actionDateTime}");
        }
        if (record.getActionUserName() != null) {
            stringBuffer.append(" AND ACTION_USER_NAME = #{actionUserName}");
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
        if (record.getUpdateUserCode() != null) {
            stringBuffer.append(" AND UPDATE_USER_CODE = #{updateUserCode}");
        }
        if (record.getUpdateDateTime() != null) {
            stringBuffer.append(" AND UPDATE_DATE_TIME = #{updateDateTime}");
        }

        WHERE(stringBuffer.toString());

        return SQL();
    }
}
