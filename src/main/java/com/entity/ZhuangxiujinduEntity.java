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
 * 装修进度
 *
 * @author 
 * @email
 */
@TableName("zhuangxiujindu")
public class ZhuangxiujinduEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhuangxiujinduEntity() {

	}

	public ZhuangxiujinduEntity(T t) {
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
        return "Zhuangxiujindu{" +
            "id=" + id +
            ", lixiangxiangmuId=" + lixiangxiangmuId +
            ", zhuangxiujinduName=" + zhuangxiujinduName +
            ", zhuangxiujinduPhoto=" + zhuangxiujinduPhoto +
            ", zhuangxiujinduText=" + zhuangxiujinduText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
