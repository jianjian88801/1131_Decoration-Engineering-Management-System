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
 * 合同管理
 *
 * @author 
 * @email
 */
@TableName("hetong")
public class HetongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HetongEntity() {

	}

	public HetongEntity(T t) {
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
     * 合同标题
     */
    @TableField(value = "hetong_name")

    private String hetongName;


    /**
     * 合同文件
     */
    @TableField(value = "hetong_file")

    private String hetongFile;


    /**
     * 合同详情
     */
    @TableField(value = "hetong_text")

    private String hetongText;


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
	 * 设置：合同标题
	 */
    public String getHetongName() {
        return hetongName;
    }


    /**
	 * 获取：合同标题
	 */

    public void setHetongName(String hetongName) {
        this.hetongName = hetongName;
    }
    /**
	 * 设置：合同文件
	 */
    public String getHetongFile() {
        return hetongFile;
    }


    /**
	 * 获取：合同文件
	 */

    public void setHetongFile(String hetongFile) {
        this.hetongFile = hetongFile;
    }
    /**
	 * 设置：合同详情
	 */
    public String getHetongText() {
        return hetongText;
    }


    /**
	 * 获取：合同详情
	 */

    public void setHetongText(String hetongText) {
        this.hetongText = hetongText;
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
        return "Hetong{" +
            "id=" + id +
            ", lixiangxiangmuId=" + lixiangxiangmuId +
            ", hetongName=" + hetongName +
            ", hetongFile=" + hetongFile +
            ", hetongText=" + hetongText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
