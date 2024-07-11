package com.entity.vo;

import com.entity.ZhuangshicailiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 装饰材料总计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhuangshicailiao")
public class ZhuangshicailiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
