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

import com.palette.busi.project.tms.core.entity.TmPiecesItem;
import com.palette.busi.project.tms.core.dao.TmPiecesItemSqlProvider;
import com.palette.busi.project.tms.core.base.BaseMybatisMapper;

public interface TmPiecesItemIntf extends BaseMybatisMapper {


	@Select("SELECT  TM_PIECES_ITEM_ID  AS tmPiecesItemId, TM_PIECES_ID  AS tmPiecesId, PIECES_NO  AS piecesNo, SEQ  AS seq, GOODS_CODE  AS goodsCode, GOODS_DESCRIPTION  AS goodsDescription, BRAND_NAME  AS brandName, ACTUAL_WEIGHT  AS actualWeight, APPLY_WEIGHT  AS applyWeight, VOLUME_WEIGHT  AS volumeWeight, PIECES_ITEM_QTY  AS piecesItemQty, UNIT_PRICE  AS unitPrice, UNIT_CODE  AS unitCode, AMOUNT  AS amount, CURRENCY  AS currency, SPEC  AS spec, TARIFF  AS tariff, GOODS_URL  AS goodsUrl, TARIFF_NUMBER  AS tariffNumber, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_pieces_item WHERE tm_pieces_item_id=#{tmPiecesItemId}")
	public TmPiecesItem selectTmPiecesItemById(@Param("tmPiecesItemId") int tmPiecesItemId);
	
	@Select("SELECT  TM_PIECES_ITEM_ID  AS tmPiecesItemId, TM_PIECES_ID  AS tmPiecesId, PIECES_NO  AS piecesNo, SEQ  AS seq, GOODS_CODE  AS goodsCode, GOODS_DESCRIPTION  AS goodsDescription, BRAND_NAME  AS brandName, ACTUAL_WEIGHT  AS actualWeight, APPLY_WEIGHT  AS applyWeight, VOLUME_WEIGHT  AS volumeWeight, PIECES_ITEM_QTY  AS piecesItemQty, UNIT_PRICE  AS unitPrice, UNIT_CODE  AS unitCode, AMOUNT  AS amount, CURRENCY  AS currency, SPEC  AS spec, TARIFF  AS tariff, GOODS_URL  AS goodsUrl, TARIFF_NUMBER  AS tariffNumber, COMPANY_CODE  AS companyCode, RECORD_VERSION  AS recordVersion, CREATE_USER_CODE  AS createUserCode, CREATE_DATE_TIME  AS createDateTime, UPDATE_USER_CODE  AS updateUserCode, UPDATE_DATE_TIME  AS updateDateTime FROM tm_pieces_item")
	public List<TmPiecesItem> selectAllTmPiecesItem();
	
	@Insert("insert into tm_pieces_item ( TM_PIECES_ITEM_ID, TM_PIECES_ID, PIECES_NO, SEQ, GOODS_CODE, GOODS_DESCRIPTION, BRAND_NAME, ACTUAL_WEIGHT, APPLY_WEIGHT, VOLUME_WEIGHT, PIECES_ITEM_QTY, UNIT_PRICE, UNIT_CODE, AMOUNT, CURRENCY, SPEC, TARIFF, GOODS_URL, TARIFF_NUMBER, COMPANY_CODE, RECORD_VERSION, CREATE_USER_CODE, CREATE_DATE_TIME, UPDATE_USER_CODE, UPDATE_DATE_TIME ) values (#{tmPiecesItemId},#{tmPiecesId},#{piecesNo},#{seq},#{goodsCode},#{goodsDescription},#{brandName},#{actualWeight},#{applyWeight},#{volumeWeight},#{piecesItemQty},#{unitPrice},#{unitCode},#{amount},#{currency},#{spec},#{tariff},#{goodsUrl},#{tariffNumber},#{companyCode},#{recordVersion},#{createUserCode},#{createDateTime},#{updateUserCode},#{updateDateTime})")
	public int insertTmPiecesItem(TmPiecesItem tmPiecesItem);

	@UpdateProvider(type=TmPiecesItemSqlProvider.class, method="update")
	public int updateTmPiecesItem(TmPiecesItem tmPiecesItem);
	
	@Delete("delete from tm_pieces_item where tm_pieces_item_id = #{tmPiecesItemId}")
	public int deleteTmPiecesItem(@Param("tmPiecesItemId") int tmPiecesItemId);

    @SelectProvider(type=TmPiecesItemSqlProvider.class, method="selectAllByRecord")
    @ResultType(TmPiecesItem.class)
    public List<TmPiecesItem> selectAllByRecord(TmPiecesItem record);
    
}