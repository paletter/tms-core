package com.palette.busi.project.tms.core.entity;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.palette.busi.project.tms.core.base.BasePo;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class TmPiecesCurrent extends BasePo {

	private static final long serialVersionUID = 1L;
	
    private Integer tmPiecesCurrentId;
    private Integer tmPiecesId;
    private String piecesNo;
    private String actionCode;
    private String memo;
    private String actionUserName;
    private Date actionDateTime;
    private String companyCode;
    private Integer recordVersion;
    private String createUserCode;
    private Date createDateTime;
    private String updateUserCode;
    private Date updateDateTime;
    
    public Integer getTmPiecesCurrentId() {
        return tmPiecesCurrentId;
    }
        
    public void setTmPiecesCurrentId(Integer tmPiecesCurrentId) {
        this.tmPiecesCurrentId = tmPiecesCurrentId;
    }
        
    public Integer getTmPiecesId() {
        return tmPiecesId;
    }
        
    public void setTmPiecesId(Integer tmPiecesId) {
        this.tmPiecesId = tmPiecesId;
    }
        
    public String getPiecesNo() {
        return piecesNo;
    }
        
    public void setPiecesNo(String piecesNo) {
        this.piecesNo = piecesNo;
    }
        
    public String getActionCode() {
        return actionCode;
    }
        
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
        
    public String getMemo() {
        return memo;
    }
        
    public void setMemo(String memo) {
        this.memo = memo;
    }
        
    public String getActionUserName() {
        return actionUserName;
    }
        
    public void setActionUserName(String actionUserName) {
        this.actionUserName = actionUserName;
    }
        
    public Date getActionDateTime() {
        return actionDateTime;
    }
        
    public void setActionDateTime(Date actionDateTime) {
        this.actionDateTime = actionDateTime;
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