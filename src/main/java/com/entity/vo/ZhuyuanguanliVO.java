package com.entity.vo;

import com.entity.ZhuyuanguanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 住院
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhuyuanguanli")
public class ZhuyuanguanliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 患者
     */

    @TableField(value = "huanzhe_id")
    private Integer huanzheId;


    /**
     * 医生
     */

    @TableField(value = "yisheng_id")
    private Integer yishengId;


    /**
     * 病房
     */

    @TableField(value = "bingfang_id")
    private Integer bingfangId;


    /**
     * 住院途径
     */

    @TableField(value = "zhuyuantujing_types")
    private Integer zhuyuantujingTypes;


    /**
     * 住院详情
     */

    @TableField(value = "zhuyuanguanli_content")
    private String zhuyuanguanliContent;


    /**
     * 住院时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：患者
	 */
    public Integer getHuanzheId() {
        return huanzheId;
    }


    /**
	 * 获取：患者
	 */

    public void setHuanzheId(Integer huanzheId) {
        this.huanzheId = huanzheId;
    }
    /**
	 * 设置：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }


    /**
	 * 获取：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
    }
    /**
	 * 设置：病房
	 */
    public Integer getBingfangId() {
        return bingfangId;
    }


    /**
	 * 获取：病房
	 */

    public void setBingfangId(Integer bingfangId) {
        this.bingfangId = bingfangId;
    }
    /**
	 * 设置：住院途径
	 */
    public Integer getZhuyuantujingTypes() {
        return zhuyuantujingTypes;
    }


    /**
	 * 获取：住院途径
	 */

    public void setZhuyuantujingTypes(Integer zhuyuantujingTypes) {
        this.zhuyuantujingTypes = zhuyuantujingTypes;
    }
    /**
	 * 设置：住院详情
	 */
    public String getZhuyuanguanliContent() {
        return zhuyuanguanliContent;
    }


    /**
	 * 获取：住院详情
	 */

    public void setZhuyuanguanliContent(String zhuyuanguanliContent) {
        this.zhuyuanguanliContent = zhuyuanguanliContent;
    }
    /**
	 * 设置：住院时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：住院时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
