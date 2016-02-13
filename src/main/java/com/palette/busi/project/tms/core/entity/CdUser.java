package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class CdUser extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer cdUserId;
    private String userName;
    private String fullName;
    private String gender;
    private String memo;
    private Integer isActive;
    private String companyCode;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getCdUserId() {
        return cdUserId;
    }
        
    public void setCdUserId(Integer cdUserId) {
        this.cdUserId = cdUserId;
    }
        
    public String getUserName() {
        return userName;
    }
        
    public void setUserName(String userName) {
        this.userName = userName;
    }
        
    public String getFullName() {
        return fullName;
    }
        
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
        
    public String getGender() {
        return gender;
    }
        
    public void setGender(String gender) {
        this.gender = gender;
    }
        
    public String getMemo() {
        return memo;
    }
        
    public void setMemo(String memo) {
        this.memo = memo;
    }
        
    public Integer getIsActive() {
        return isActive;
    }
        
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
        
    public String getCompanyCode() {
        return companyCode;
    }
        
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
        
    public Integer getRecordVersion() {
        return recordVersion;
    }
        
    public void setRecordVersion(Integer recordVersion) {
        this.recordVersion = recordVersion;
    }
        
    public String getCreateUserCode() {
        return createUserCode;
    }
        
    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }
        
    public Date getCreateDateTime() {
        return createDateTime;
    }
        
    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
        
    public String getUpdateUserCode() {
        return updateUserCode;
    }
        
    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }
        
    public Date getUpdateDateTime() {
        return updateDateTime;
    }
        
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
        
}