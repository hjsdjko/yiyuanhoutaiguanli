package com.entity.view;

import com.entity.BingfangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 病房
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("bingfang")
public class BingfangView extends BingfangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 床位的值
		*/
		private String chuangweiValue;



	public BingfangView() {

	}

	public BingfangView(BingfangEntity bingfangEntity) {
		try {
			BeanUtils.copyProperties(this, bingfangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 床位的值
			*/
			public String getChuangweiValue() {
				return chuangweiValue;
			}
			/**
			* 设置： 床位的值
			*/
			public void setChuangweiValue(String chuangweiValue) {
				this.chuangweiValue = chuangweiValue;
			}













}
