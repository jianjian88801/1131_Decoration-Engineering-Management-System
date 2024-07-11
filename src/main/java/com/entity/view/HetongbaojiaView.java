package com.entity.view;

import com.entity.HetongbaojiaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 合同报价
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hetongbaojia")
public class HetongbaojiaView extends HetongbaojiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 hetong
			/**
			* 合同标题
			*/
			private String hetongName;
			/**
			* 合同文件
			*/
			private String hetongFile;
			/**
			* 合同详情
			*/
			private String hetongText;

	public HetongbaojiaView() {

	}

	public HetongbaojiaView(HetongbaojiaEntity hetongbaojiaEntity) {
		try {
			BeanUtils.copyProperties(this, hetongbaojiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}









				//级联表的get和set hetong

					/**
					* 获取： 合同标题
					*/
					public String getHetongName() {
						return hetongName;
					}
					/**
					* 设置： 合同标题
					*/
					public void setHetongName(String hetongName) {
						this.hetongName = hetongName;
					}
					/**
					* 获取： 合同文件
					*/
					public String getHetongFile() {
						return hetongFile;
					}
					/**
					* 设置： 合同文件
					*/
					public void setHetongFile(String hetongFile) {
						this.hetongFile = hetongFile;
					}
					/**
					* 获取： 合同详情
					*/
					public String getHetongText() {
						return hetongText;
					}
					/**
					* 设置： 合同详情
					*/
					public void setHetongText(String hetongText) {
						this.hetongText = hetongText;
					}


















}
