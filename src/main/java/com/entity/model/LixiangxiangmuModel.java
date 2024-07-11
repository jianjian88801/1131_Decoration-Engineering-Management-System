package com.entity.model;

import com.entity.LixiangxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 立项项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LixiangxiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 项目编号
     */
    private String lixiangxiangmuUuidNumber;


    /**
     * 项目名称
     */
    private String lixiangxiangmuName;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 项目类型
     */
    private Integer lixiangxiangmuTypes;


    /**
     * 项目文件
     */
    private String lixiangxiangmuFile;


    /**
     * 审核结果
     */
    private Integer lixiangxiangmuYesnoTypes;


    /**
     * 审核原因
     */
    private String lixiangxiangmuYesnoText;


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
	 * 获取：项目编号
	 */
    public String getLixiangxiangmuUuidNumber() {
        return lixiangxiangmuUuidNumber;
    }


    /**
	 * 设置：项目编号
	 */
    public void setLixiangxiangmuUuidNumber(String lixiangxiangmuUuidNumber) {
        this.lixiangxiangmuUuidNumber = lixiangxiangmuUuidNumber;
    }
    /**
	 * 获取：项目名称
	 */
    public String getLixiangxiangmuName() {
        return lixiangxiangmuName;
    }


    /**
	 * 设置：项目名称
	 */
    public void setLixiangxiangmuName(String lixiangxiangmuName) {
        this.lixiangxiangmuName = lixiangxiangmuName;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getLixiangxiangmuTypes() {
        return lixiangxiangmuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setLixiangxiangmuTypes(Integer lixiangxiangmuTypes) {
        this.lixiangxiangmuTypes = lixiangxiangmuTypes;
    }
    /**
	 * 获取：项目文件
	 */
    public String getLixiangxiangmuFile() {
        return lixiangxiangmuFile;
    }


    /**
	 * 设置：项目文件
	 */
    public void setLixiangxiangmuFile(String lixiangxiangmuFile) {
        this.lixiangxiangmuFile = lixiangxiangmuFile;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getLixiangxiangmuYesnoTypes() {
        return lixiangxiangmuYesnoTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setLixiangxiangmuYesnoTypes(Integer lixiangxiangmuYesnoTypes) {
        this.lixiangxiangmuYesnoTypes = lixiangxiangmuYesnoTypes;
    }
    /**
	 * 获取：审核原因
	 */
    public String getLixiangxiangmuYesnoText() {
        return lixiangxiangmuYesnoText;
    }


    /**
	 * 设置：审核原因
	 */
    public void setLixiangxiangmuYesnoText(String lixiangxiangmuYesnoText) {
        this.lixiangxiangmuYesnoText = lixiangxiangmuYesnoText;
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
