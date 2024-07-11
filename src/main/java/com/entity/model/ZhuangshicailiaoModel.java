package com.entity.model;

import com.entity.ZhuangshicailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 装饰材料总计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhuangshicailiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 立项项目
     */
    private Integer lixiangxiangmuId;


    /**
     * 材料名称
     */
    private String zhuangshicailiaoName;


    /**
     * 材料图片
     */
    private String zhuangshicailiaoPhoto;


    /**
     * 材料价格
     */
    private Double zhuangshicailiaoMoney;


    /**
     * 材料类型
     */
    private Integer zhuangshicailiaoTypes;


    /**
     * 采购数量
     */
    private Integer zhuangshicailiaoNumber;


    /**
     * 单位
     */
    private String zhuangshicailiaoDanwei;


    /**
     * 材料详情
     */
    private String zhuangshicailiaoText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：立项项目
	 */
    public Integer getLixiangxiangmuId() {
        return lixiangxiangmuId;
    }


    /**
	 * 设置：立项项目
	 */
    public void setLixiangxiangmuId(Integer lixiangxiangmuId) {
        this.lixiangxiangmuId = lixiangxiangmuId;
    }
    /**
	 * 获取：材料名称
	 */
    public String getZhuangshicailiaoName() {
        return zhuangshicailiaoName;
    }


    /**
	 * 设置：材料名称
	 */
    public void setZhuangshicailiaoName(String zhuangshicailiaoName) {
        this.zhuangshicailiaoName = zhuangshicailiaoName;
    }
    /**
	 * 获取：材料图片
	 */
    public String getZhuangshicailiaoPhoto() {
        return zhuangshicailiaoPhoto;
    }


    /**
	 * 设置：材料图片
	 */
    public void setZhuangshicailiaoPhoto(String zhuangshicailiaoPhoto) {
        this.zhuangshicailiaoPhoto = zhuangshicailiaoPhoto;
    }
    /**
	 * 获取：材料价格
	 */
    public Double getZhuangshicailiaoMoney() {
        return zhuangshicailiaoMoney;
    }


    /**
	 * 设置：材料价格
	 */
    public void setZhuangshicailiaoMoney(Double zhuangshicailiaoMoney) {
        this.zhuangshicailiaoMoney = zhuangshicailiaoMoney;
    }
    /**
	 * 获取：材料类型
	 */
    public Integer getZhuangshicailiaoTypes() {
        return zhuangshicailiaoTypes;
    }


    /**
	 * 设置：材料类型
	 */
    public void setZhuangshicailiaoTypes(Integer zhuangshicailiaoTypes) {
        this.zhuangshicailiaoTypes = zhuangshicailiaoTypes;
    }
    /**
	 * 获取：采购数量
	 */
    public Integer getZhuangshicailiaoNumber() {
        return zhuangshicailiaoNumber;
    }


    /**
	 * 设置：采购数量
	 */
    public void setZhuangshicailiaoNumber(Integer zhuangshicailiaoNumber) {
        this.zhuangshicailiaoNumber = zhuangshicailiaoNumber;
    }
    /**
	 * 获取：单位
	 */
    public String getZhuangshicailiaoDanwei() {
        return zhuangshicailiaoDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setZhuangshicailiaoDanwei(String zhuangshicailiaoDanwei) {
        this.zhuangshicailiaoDanwei = zhuangshicailiaoDanwei;
    }
    /**
	 * 获取：材料详情
	 */
    public String getZhuangshicailiaoText() {
        return zhuangshicailiaoText;
    }


    /**
	 * 设置：材料详情
	 */
    public void setZhuangshicailiaoText(String zhuangshicailiaoText) {
        this.zhuangshicailiaoText = zhuangshicailiaoText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
