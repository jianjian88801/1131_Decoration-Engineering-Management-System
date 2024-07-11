package com.entity.vo;

import com.entity.ZhuangxiujinduEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 装修进度
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhuangxiujindu")
public class ZhuangxiujinduVO implements Serializable {
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
     * 进度标题
     */

    @TableField(value = "zhuangxiujindu_name")
    private String zhuangxiujinduName;


    /**
     * 进度图片
     */

    @TableField(value = "zhuangxiujindu_photo")
    private String zhuangxiujinduPhoto;


    /**
     * 进度详情
     */

    @TableField(value = "zhuangxiujindu_text")
    private String zhuangxiujinduText;


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
	 * 设置：进度标题
	 */
    public String getZhuangxiujinduName() {
        return zhuangxiujinduName;
    }


    /**
	 * 获取：进度标题
	 */

    public void setZhuangxiujinduName(String zhuangxiujinduName) {
        this.zhuangxiujinduName = zhuangxiujinduName;
    }
    /**
	 * 设置：进度图片
	 */
    public String getZhuangxiujinduPhoto() {
        return zhuangxiujinduPhoto;
    }


    /**
	 * 获取：进度图片
	 */

    public void setZhuangxiujinduPhoto(String zhuangxiujinduPhoto) {
        this.zhuangxiujinduPhoto = zhuangxiujinduPhoto;
    }
    /**
	 * 设置：进度详情
	 */
    public String getZhuangxiujinduText() {
        return zhuangxiujinduText;
    }


    /**
	 * 获取：进度详情
	 */

    public void setZhuangxiujinduText(String zhuangxiujinduText) {
        this.zhuangxiujinduText = zhuangxiujinduText;
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
