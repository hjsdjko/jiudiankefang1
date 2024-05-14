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
 * 房间信息
 *
 * @author 
 * @email
 */
@TableName("fangjian")
public class FangjianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangjianEntity() {

	}

	public FangjianEntity(T t) {
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
     * 房间号
     */
    @TableField(value = "fangjian_name")

    private String fangjianName;


    /**
     * 房间类型
     */
    @TableField(value = "fangjian_types")

    private Integer fangjianTypes;


    /**
     * 所在区域
     */
    @TableField(value = "fangjian_address")

    private String fangjianAddress;


    /**
     * 房间配置
     */
    @TableField(value = "fangjian_peizhi")

    private String fangjianPeizhi;


    /**
     * 房间图片
     */
    @TableField(value = "fangjian_photo")

    private String fangjianPhoto;


    /**
     * 价格/天
     */
    @TableField(value = "fangjian_new_money")

    private Double fangjianNewMoney;


    /**
     * 房间状态
     */
    @TableField(value = "status_types")

    private Integer statusTypes;


    /**
     * 房间详情
     */
    @TableField(value = "fangjian_content")

    private String fangjianContent;


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
	 * 设置：房间号
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 获取：房间号
	 */

    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 设置：房间类型
	 */
    public Integer getFangjianTypes() {
        return fangjianTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setFangjianTypes(Integer fangjianTypes) {
        this.fangjianTypes = fangjianTypes;
    }
    /**
	 * 设置：所在区域
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }


    /**
	 * 获取：所在区域
	 */

    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 设置：房间配置
	 */
    public String getFangjianPeizhi() {
        return fangjianPeizhi;
    }


    /**
	 * 获取：房间配置
	 */

    public void setFangjianPeizhi(String fangjianPeizhi) {
        this.fangjianPeizhi = fangjianPeizhi;
    }
    /**
	 * 设置：房间图片
	 */
    public String getFangjianPhoto() {
        return fangjianPhoto;
    }


    /**
	 * 获取：房间图片
	 */

    public void setFangjianPhoto(String fangjianPhoto) {
        this.fangjianPhoto = fangjianPhoto;
    }
    /**
	 * 设置：价格/天
	 */
    public Double getFangjianNewMoney() {
        return fangjianNewMoney;
    }


    /**
	 * 获取：价格/天
	 */

    public void setFangjianNewMoney(Double fangjianNewMoney) {
        this.fangjianNewMoney = fangjianNewMoney;
    }
    /**
	 * 设置：房间状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 获取：房间状态
	 */

    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 设置：房间详情
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }


    /**
	 * 获取：房间详情
	 */

    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
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
        return "Fangjian{" +
            "id=" + id +
            ", fangjianName=" + fangjianName +
            ", fangjianTypes=" + fangjianTypes +
            ", fangjianAddress=" + fangjianAddress +
            ", fangjianPeizhi=" + fangjianPeizhi +
            ", fangjianPhoto=" + fangjianPhoto +
            ", fangjianNewMoney=" + fangjianNewMoney +
            ", statusTypes=" + statusTypes +
            ", fangjianContent=" + fangjianContent +
            ", createTime=" + createTime +
        "}";
    }
}
