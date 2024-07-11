package com.entity.view;

import com.entity.LixiangxiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 立项项目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("lixiangxiangmu")
public class LixiangxiangmuView extends LixiangxiangmuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 项目类型的值
		*/
		private String lixiangxiangmuValue;
		/**
		* 审核结果的值
		*/
		private String lixiangxiangmuYesnoValue;



		//级联表 kehu
			/**
			* 客户姓名
			*/
			private String kehuName;
			/**
			* 头像
			*/
			private String kehuPhoto;
			/**
			* 联系方式
			*/
			private String kehuPhone;
			/**
			* 邮箱
			*/
			private String kehuEmail;
			/**
			* 假删
			*/
			private Integer kehuDelete;

		//级联表 yonghu
			/**
			* 员工姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 员工身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public LixiangxiangmuView() {

	}

	public LixiangxiangmuView(LixiangxiangmuEntity lixiangxiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, lixiangxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














				//级联表的get和set kehu
					/**
					* 获取： 客户姓名
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 客户姓名
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}
					/**
					* 获取： 头像
					*/
					public String getKehuPhoto() {
						return kehuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setKehuPhoto(String kehuPhoto) {
						this.kehuPhoto = kehuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getKehuEmail() {
						return kehuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setKehuEmail(String kehuEmail) {
						this.kehuEmail = kehuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getKehuDelete() {
						return kehuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setKehuDelete(Integer kehuDelete) {
						this.kehuDelete = kehuDelete;
					}








				//级联表的get和set yonghu
					/**
					* 获取： 员工姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}













}
