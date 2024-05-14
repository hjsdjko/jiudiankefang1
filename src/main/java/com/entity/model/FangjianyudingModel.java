package com.entity.model;

import com.entity.FangjianyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间预定
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangjianyudingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 房间
     */
    private Integer fangjianId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangjianyudingTime;


    /**
     * 退房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


    /**
     * 预定状态
     */
    private Integer fangjianyudingTypes;


    /**
     * 创建时间
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 设置：房间
	 */
    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 获取：预定时间
	 */
    public Date getFangjianyudingTime() {
        return fangjianyudingTime;
    }


    /**
	 * 设置：预定时间
	 */
    public void setFangjianyudingTime(Date fangjianyudingTime) {
        this.fangjianyudingTime = fangjianyudingTime;
    }
    /**
	 * 获取：退房时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：退房时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：预定状态
	 */
    public Integer getFangjianyudingTypes() {
        return fangjianyudingTypes;
    }


    /**
	 * 设置：预定状态
	 */
    public void setFangjianyudingTypes(Integer fangjianyudingTypes) {
        this.fangjianyudingTypes = fangjianyudingTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
