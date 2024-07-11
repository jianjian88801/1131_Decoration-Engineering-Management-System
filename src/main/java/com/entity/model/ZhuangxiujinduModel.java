package com.entity.model;

import com.entity.ZhuangxiujinduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 装修进度
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhuangxiujinduModel implements Serializable {
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
     * 进度标题
     */
    private String zhuangxiujinduName;


    /**
     * 进度图片
     */
    private String zhuangxiujinduPhoto;


    /**
     * 进度详情
     */
    private String zhuangxiujinduText;


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
	 * 获取：进度标题
	 */
    public String getZhuangxiujinduName() {
        return zhuangxiujinduName;
    }


    /**
	 * 设置：进度标题
	 */
    public void setZhuangxiujinduName(String zhuangxiujinduName) {
        this.zhuangxiujinduName = zhuangxiujinduName;
    }
    /**
	 * 获取：进度图片
	 */
    public String getZhuangxiujinduPhoto() {
        return zhuangxiujinduPhoto;
    }


    /**
	 * 设置：进度图片
	 */
    public void setZhuangxiujinduPhoto(String zhuangxiujinduPhoto) {
        this.zhuangxiujinduPhoto = zhuangxiujinduPhoto;
    }
    /**
	 * 获取：进度详情
	 */
    public String getZhuangxiujinduText() {
        return zhuangxiujinduText;
    }


    /**
	 * 设置：进度详情
	 */
    public void setZhuangxiujinduText(String zhuangxiujinduText) {
        this.zhuangxiujinduText = zhuangxiujinduText;
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
