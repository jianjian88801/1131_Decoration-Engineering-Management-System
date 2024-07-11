package com.entity.vo;

import com.entity.LixiangxiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 立项项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("lixiangxiangmu")
public class LixiangxiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
