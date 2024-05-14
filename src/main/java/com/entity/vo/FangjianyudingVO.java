package com.entity.vo;

import com.entity.FangjianyudingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间预定
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjianyuding")
public class FangjianyudingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 房间
     */

    @TableField(value = "fangjian_id")
    private Integer fangjianId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangjianyuding_time")
    private Date fangjianyudingTime;


    /**
     * 退房时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 预定状态
     */

    @TableField(value = "fangjianyuding_types")
    private Integer fangjianyudingTypes;


    /**
     * 创建时间
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 获取：房间
	 */

    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getFangjianyudingTime() {
        return fangjianyudingTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setFangjianyudingTime(Date fangjianyudingTime) {
        this.fangjianyudingTime = fangjianyudingTime;
    }
    /**
	 * 设置：退房时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：退房时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：预定状态
	 */
    public Integer getFangjianyudingTypes() {
        return fangjianyudingTypes;
    }


    /**
	 * 获取：预定状态
	 */

    public void setFangjianyudingTypes(Integer fangjianyudingTypes) {
        this.fangjianyudingTypes = fangjianyudingTypes;
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

}
