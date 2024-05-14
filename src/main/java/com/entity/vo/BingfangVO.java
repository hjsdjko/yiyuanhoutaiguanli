package com.entity.vo;

import com.entity.BingfangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 病房
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bingfang")
public class BingfangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 病房名称
     */

    @TableField(value = "bingfang_name")
    private String bingfangName;


    /**
     * 病房位置
     */

    @TableField(value = "bingfang_address")
    private String bingfangAddress;


    /**
     * 床位
     */

    @TableField(value = "chuangwei_types")
    private Integer chuangweiTypes;


    /**
     * 病房介绍
     */

    @TableField(value = "bingfang_content")
    private String bingfangContent;


    /**
     * 添加时间
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
	 * 设置：病房名称
	 */
    public String getBingfangName() {
        return bingfangName;
    }


    /**
	 * 获取：病房名称
	 */

    public void setBingfangName(String bingfangName) {
        this.bingfangName = bingfangName;
    }
    /**
	 * 设置：病房位置
	 */
    public String getBingfangAddress() {
        return bingfangAddress;
    }


    /**
	 * 获取：病房位置
	 */

    public void setBingfangAddress(String bingfangAddress) {
        this.bingfangAddress = bingfangAddress;
    }
    /**
	 * 设置：床位
	 */
    public Integer getChuangweiTypes() {
        return chuangweiTypes;
    }


    /**
	 * 获取：床位
	 */

    public void setChuangweiTypes(Integer chuangweiTypes) {
        this.chuangweiTypes = chuangweiTypes;
    }
    /**
	 * 设置：病房介绍
	 */
    public String getBingfangContent() {
        return bingfangContent;
    }


    /**
	 * 获取：病房介绍
	 */

    public void setBingfangContent(String bingfangContent) {
        this.bingfangContent = bingfangContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
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
