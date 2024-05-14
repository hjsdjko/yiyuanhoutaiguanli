package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 病房
 *
 * @author 
 * @email
 */
@TableName("bingfang")
public class BingfangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BingfangEntity() {

	}

	public BingfangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Bingfang{" +
            "id=" + id +
            ", bingfangName=" + bingfangName +
            ", bingfangAddress=" + bingfangAddress +
            ", chuangweiTypes=" + chuangweiTypes +
            ", bingfangContent=" + bingfangContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
