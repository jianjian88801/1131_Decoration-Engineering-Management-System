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
 * 装饰材料总计划
 *
 * @author 
 * @email
 */
@TableName("zhuangshicailiao")
public class ZhuangshicailiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhuangshicailiaoEntity() {

	}

	public ZhuangshicailiaoEntity(T t) {
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
     * 立项项目
     */
    @TableField(value = "lixiangxiangmu_id")

    private Integer lixiangxiangmuId;


    /**
     * 材料名称
     */
    @TableField(value = "zhuangshicailiao_name")

    private String zhuangshicailiaoName;


    /**
     * 材料图片
     */
    @TableField(value = "zhuangshicailiao_photo")

    private String zhuangshicailiaoPhoto;


    /**
     * 材料价格
     */
    @TableField(value = "zhuangshicailiao_money")

    private Double zhuangshicailiaoMoney;


    /**
     * 材料类型
     */
    @TableField(value = "zhuangshicailiao_types")

    private Integer zhuangshicailiaoTypes;


    /**
     * 采购数量
     */
    @TableField(value = "zhuangshicailiao_number")

    private Integer zhuangshicailiaoNumber;


    /**
     * 单位
     */
    @TableField(value = "zhuangshicailiao_danwei")

    private String zhuangshicailiaoDanwei;


    /**
     * 材料详情
     */
    @TableField(value = "zhuangshicailiao_text")

    private String zhuangshicailiaoText;


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
	 * 设置：立项项目
	 */
    public Integer getLixiangxiangmuId() {
        return lixiangxiangmuId;
    }


    /**
	 * 获取：立项项目
	 */

    public void setLixiangxiangmuId(Integer lixiangxiangmuId) {
        this.lixiangxiangmuId = lixiangxiangmuId;
    }
    /**
	 * 设置：材料名称
	 */
    public String getZhuangshicailiaoName() {
        return zhuangshicailiaoName;
    }


    /**
	 * 获取：材料名称
	 */

    public void setZhuangshicailiaoName(String zhuangshicailiaoName) {
        this.zhuangshicailiaoName = zhuangshicailiaoName;
    }
    /**
	 * 设置：材料图片
	 */
    public String getZhuangshicailiaoPhoto() {
        return zhuangshicailiaoPhoto;
    }


    /**
	 * 获取：材料图片
	 */

    public void setZhuangshicailiaoPhoto(String zhuangshicailiaoPhoto) {
        this.zhuangshicailiaoPhoto = zhuangshicailiaoPhoto;
    }
    /**
	 * 设置：材料价格
	 */
    public Double getZhuangshicailiaoMoney() {
        return zhuangshicailiaoMoney;
    }


    /**
	 * 获取：材料价格
	 */

    public void setZhuangshicailiaoMoney(Double zhuangshicailiaoMoney) {
        this.zhuangshicailiaoMoney = zhuangshicailiaoMoney;
    }
    /**
	 * 设置：材料类型
	 */
    public Integer getZhuangshicailiaoTypes() {
        return zhuangshicailiaoTypes;
    }


    /**
	 * 获取：材料类型
	 */

    public void setZhuangshicailiaoTypes(Integer zhuangshicailiaoTypes) {
        this.zhuangshicailiaoTypes = zhuangshicailiaoTypes;
    }
    /**
	 * 设置：采购数量
	 */
    public Integer getZhuangshicailiaoNumber() {
        return zhuangshicailiaoNumber;
    }


    /**
	 * 获取：采购数量
	 */

    public void setZhuangshicailiaoNumber(Integer zhuangshicailiaoNumber) {
        this.zhuangshicailiaoNumber = zhuangshicailiaoNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getZhuangshicailiaoDanwei() {
        return zhuangshicailiaoDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setZhuangshicailiaoDanwei(String zhuangshicailiaoDanwei) {
        this.zhuangshicailiaoDanwei = zhuangshicailiaoDanwei;
    }
    /**
	 * 设置：材料详情
	 */
    public String getZhuangshicailiaoText() {
        return zhuangshicailiaoText;
    }


    /**
	 * 获取：材料详情
	 */

    public void setZhuangshicailiaoText(String zhuangshicailiaoText) {
        this.zhuangshicailiaoText = zhuangshicailiaoText;
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
        return "Zhuangshicailiao{" +
            "id=" + id +
            ", lixiangxiangmuId=" + lixiangxiangmuId +
            ", zhuangshicailiaoName=" + zhuangshicailiaoName +
            ", zhuangshicailiaoPhoto=" + zhuangshicailiaoPhoto +
            ", zhuangshicailiaoMoney=" + zhuangshicailiaoMoney +
            ", zhuangshicailiaoTypes=" + zhuangshicailiaoTypes +
            ", zhuangshicailiaoNumber=" + zhuangshicailiaoNumber +
            ", zhuangshicailiaoDanwei=" + zhuangshicailiaoDanwei +
            ", zhuangshicailiaoText=" + zhuangshicailiaoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
