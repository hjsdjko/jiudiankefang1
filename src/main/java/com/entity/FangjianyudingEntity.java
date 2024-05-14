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
 * 房间预定
 *
 * @author 
 * @email
 */
@TableName("fangjianyuding")
public class FangjianyudingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangjianyudingEntity() {

	}

	public FangjianyudingEntity(T t) {
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
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

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

    @Override
    public String toString() {
        return "Fangjianyuding{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", fangjianId=" + fangjianId +
            ", fangjianyudingTime=" + fangjianyudingTime +
            ", updateTime=" + updateTime +
            ", fangjianyudingTypes=" + fangjianyudingTypes +
            ", createTime=" + createTime +
        "}";
    }
}
