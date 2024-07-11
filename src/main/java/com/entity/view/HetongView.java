package com.entity.view;

import com.entity.HetongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 合同管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("hetong")
public class HetongView extends HetongEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 lixiangxiangmu
			/**
			* 项目编号
			*/
			private String lixiangxiangmuUuidNumber;
			/**
			* 项目名称
			*/
			private String lixiangxiangmuName;
			/**
			* 立项项目 的 员工
			*/
			private Integer lixiangxiangmuYonghuId;
			/**
			* 立项项目 的 客户
			*/
			private Integer lixiangxiangmuKehuId;
			/**
			* 项目类型
			*/
			private Integer lixiangxiangmuTypes;
				/**
				* 项目类型的值
				*/
				private String lixiangxiangmuValue;
			/**
			* 项目文件
			*/
			private String lixiangxiangmuFile;
			/**
			* 审核结果
			*/
			private Integer lixiangxiangmuYesnoTypes;
				/**
				* 审核结果的值
				*/
				private String lixiangxiangmuYesnoValue;
			/**
			* 审核原因
			*/
			private String lixiangxiangmuYesnoText;

	public HetongView() {

	}

	public HetongView(HetongEntity hetongEntity) {
		try {
			BeanUtils.copyProperties(this, hetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}















				//级联表的get和set lixiangxiangmu
					/**
					* 获取： 项目编号
					*/
					public String getLixiangxiangmuUuidNumber() {
						return lixiangxiangmuUuidNumber;
					}
					/**
					* 设置： 项目编号
					*/
					public void setLixiangxiangmuUuidNumber(String lixiangxiangmuUuidNumber) {
						this.lixiangxiangmuUuidNumber = lixiangxiangmuUuidNumber;
					}
					/**
					* 获取： 项目名称
					*/
					public String getLixiangxiangmuName() {
						return lixiangxiangmuName;
					}
					/**
					* 设置： 项目名称
					*/
					public void setLixiangxiangmuName(String lixiangxiangmuName) {
						this.lixiangxiangmuName = lixiangxiangmuName;
					}
					/**
					* 获取：立项项目 的 员工
					*/
					public Integer getLixiangxiangmuYonghuId() {
						return lixiangxiangmuYonghuId;
					}
					/**
					* 设置：立项项目 的 员工
					*/
					public void setLixiangxiangmuYonghuId(Integer lixiangxiangmuYonghuId) {
						this.lixiangxiangmuYonghuId = lixiangxiangmuYonghuId;
					}

					/**
					* 获取：立项项目 的 客户
					*/
					public Integer getLixiangxiangmuKehuId() {
						return lixiangxiangmuKehuId;
					}
					/**
					* 设置：立项项目 的 客户
					*/
					public void setLixiangxiangmuKehuId(Integer lixiangxiangmuKehuId) {
						this.lixiangxiangmuKehuId = lixiangxiangmuKehuId;
					}

					/**
					* 获取： 项目类型
					*/
					public Integer getLixiangxiangmuTypes() {
						return lixiangxiangmuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setLixiangxiangmuTypes(Integer lixiangxiangmuTypes) {
						this.lixiangxiangmuTypes = lixiangxiangmuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getLixiangxiangmuValue() {
							return lixiangxiangmuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setLixiangxiangmuValue(String lixiangxiangmuValue) {
							this.lixiangxiangmuValue = lixiangxiangmuValue;
						}
					/**
					* 获取： 项目文件
					*/
					public String getLixiangxiangmuFile() {
						return lixiangxiangmuFile;
					}
					/**
					* 设置： 项目文件
					*/
					public void setLixiangxiangmuFile(String lixiangxiangmuFile) {
						this.lixiangxiangmuFile = lixiangxiangmuFile;
					}
					/**
					* 获取： 审核结果
					*/
					public Integer getLixiangxiangmuYesnoTypes() {
						return lixiangxiangmuYesnoTypes;
					}
					/**
					* 设置： 审核结果
					*/
					public void setLixiangxiangmuYesnoTypes(Integer lixiangxiangmuYesnoTypes) {
						this.lixiangxiangmuYesnoTypes = lixiangxiangmuYesnoTypes;
					}


						/**
						* 获取： 审核结果的值
						*/
						public String getLixiangxiangmuYesnoValue() {
							return lixiangxiangmuYesnoValue;
						}
						/**
						* 设置： 审核结果的值
						*/
						public void setLixiangxiangmuYesnoValue(String lixiangxiangmuYesnoValue) {
							this.lixiangxiangmuYesnoValue = lixiangxiangmuYesnoValue;
						}
					/**
					* 获取： 审核原因
					*/
					public String getLixiangxiangmuYesnoText() {
						return lixiangxiangmuYesnoText;
					}
					/**
					* 设置： 审核原因
					*/
					public void setLixiangxiangmuYesnoText(String lixiangxiangmuYesnoText) {
						this.lixiangxiangmuYesnoText = lixiangxiangmuYesnoText;
					}












}
