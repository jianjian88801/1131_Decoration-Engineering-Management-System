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
 * 立项项目
 *
 * @author 
 * @email
 */
@TableName("lixiangxiangmu")
public class LixiangxiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LixiangxiangmuEntity() {

	}

	public LixiangxiangmuEntity(T t) {
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
     * 项目编号
     */
    @TableField(value = "lixiangxiangmu_uuid_number")

    private String lixiangxiangmuUuidNumber;


    /**
     * 项目名称
     */
    @TableField(value = "lixiangxiangmu_name")

    private String lixiangxiangmuName;


    /**
     * 员工
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 客户
     */
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 项目类型
     */
    @TableField(value = "lixiangxiangmu_types")

    private Integer lixiangxiangmuTypes;


    /**
     * 项目文件
     */
    @TableField(value = "lixiangxiangmu_file")

    private String lixiangxiangmuFile;


    /**
     * 审核结果
     */
    @TableField(value = "lixiangxiangmu_yesno_types")

    private Integer lixiangxiangmuYesnoTypes;


    /**
     * 审核原因
     */
    @TableField(value = "lixiangxiangmu_yesno_text")

    private String lixiangxiangmuYesnoText;


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
	 * 设置：项目编号
	 */
    public String getLixiangxiangmuUuidNumber() {
        return lixiangxiangmuUuidNumber;
    }


    /**
	 * 获取：项目编号
	 */

    public void setLixiangxiangmuUuidNumber(String lixiangxiangmuUuidNumber) {
        this.lixiangxiangmuUuidNumber = lixiangxiangmuUuidNumber;
    }
    /**
	 * 设置：项目名称
	 */
    public String getLixiangxiangmuName() {
        return lixiangxiangmuName;
    }


    /**
	 * 获取：项目名称
	 */

    public void setLixiangxiangmuName(String lixiangxiangmuName) {
        this.lixiangxiangmuName = lixiangxiangmuName;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getLixiangxiangmuTypes() {
        return lixiangxiangmuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setLixiangxiangmuTypes(Integer lixiangxiangmuTypes) {
        this.lixiangxiangmuTypes = lixiangxiangmuTypes;
    }
    /**
	 * 设置：项目文件
	 */
    public String getLixiangxiangmuFile() {
        return lixiangxiangmuFile;
    }


    /**
	 * 获取：项目文件
	 */

    public void setLixiangxiangmuFile(String lixiangxiangmuFile) {
        this.lixiangxiangmuFile = lixiangxiangmuFile;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getLixiangxiangmuYesnoTypes() {
        return lixiangxiangmuYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setLixiangxiangmuYesnoTypes(Integer lixiangxiangmuYesnoTypes) {
        this.lixiangxiangmuYesnoTypes = lixiangxiangmuYesnoTypes;
    }
    /**
	 * 设置：审核原因
	 */
    public String getLixiangxiangmuYesnoText() {
        return lixiangxiangmuYesnoText;
    }


    /**
	 * 获取：审核原因
	 */

    public void setLixiangxiangmuYesnoText(String lixiangxiangmuYesnoText) {
        this.lixiangxiangmuYesnoText = lixiangxiangmuYesnoText;
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
        return "Lixiangxiangmu{" +
            "id=" + id +
            ", lixiangxiangmuUuidNumber=" + lixiangxiangmuUuidNumber +
            ", lixiangxiangmuName=" + lixiangxiangmuName +
            ", yonghuId=" + yonghuId +
            ", kehuId=" + kehuId +
            ", lixiangxiangmuTypes=" + lixiangxiangmuTypes +
            ", lixiangxiangmuFile=" + lixiangxiangmuFile +
            ", lixiangxiangmuYesnoTypes=" + lixiangxiangmuYesnoTypes +
            ", lixiangxiangmuYesnoText=" + lixiangxiangmuYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
