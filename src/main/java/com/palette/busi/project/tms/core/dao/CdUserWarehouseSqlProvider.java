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

import com.palette.busi.project.tms.core.entity.CdUserWarehouse;
import com.palette.busi.project.tms.core.base.BaseSqlProvider;

public class CdUserWarehouseSqlProvider extends BaseSqlProvider {

	public String update(CdUserWarehouse record) {
		BEGIN();
        UPDATE("cd_user_warehouse");
        if (record.getCdUserWarehouseId() != null) {
            SET("CD_USER_WAREHOUSE_ID = #{cdUserWarehouseId}");
        }
        if (record.getCdUserId() != null) {
            SET("CD_USER_ID = #{cdUserId}");
        }
        if (record.getCdWarehouseId() != null) {
            SET("CD_WAREHOUSE_ID = #{cdWarehouseId}");
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

        WHERE("cd_user_warehouse_id = #{cdUserWarehouseId}");

        return SQL();
	}

    public String selectAllByRecord(CdUserWarehouse record) {
        BEGIN();
        SELECT("*");
        FROM("cd_user_warehouse");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 1=1 ");
        if (record.getCdUserWarehouseId() != null) {
            stringBuffer.append(" AND CD_USER_WAREHOUSE_ID = #{cdUserWarehouseId}");
        }
        if (record.getCdUserId() != null) {
            stringBuffer.append(" AND CD_USER_ID = #{cdUserId}");
        }
        if (record.getCdWarehouseId() != null) {
            stringBuffer.append(" AND CD_WAREHOUSE_ID = #{cdWarehouseId}");
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
