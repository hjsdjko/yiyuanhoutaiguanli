package com.entity.model;

import com.entity.ZhuyuanguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 住院
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhuyuanguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzheId;


    /**
     * 医生
     */
    private Integer yishengId;


    /**
     * 病房
     */
    private Integer bingfangId;


    /**
     * 住院途径
     */
    private Integer zhuyuantujingTypes;


    /**
     * 住院详情
     */
    private String zhuyuanguanliContent;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 设置：医生
	 */
    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 获取：病房
	 */
    public Integer getBingfangId() {
        return bingfangId;
    }


    /**
	 * 设置：病房
	 */
    public void setBingfangId(Integer bingfangId) {
        this.bingfangId = bingfangId;
    }
    /**
	 * 获取：住院途径
	 */
    public Integer getZhuyuantujingTypes() {
        return zhuyuantujingTypes;
    }


    /**
	 * 设置：住院途径
	 */
    public void setZhuyuantujingTypes(Integer zhuyuantujingTypes) {
        this.zhuyuantujingTypes = zhuyuantujingTypes;
    }
    /**
	 * 获取：住院详情
	 */
    public String getZhuyuanguanliContent() {
        return zhuyuanguanliContent;
    }


    /**
	 * 设置：住院详情
	 */
    public void setZhuyuanguanliContent(String zhuyuanguanliContent) {
        this.zhuyuanguanliContent = zhuyuanguanliContent;
    }
    /**
	 * 获取：住院时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：住院时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
