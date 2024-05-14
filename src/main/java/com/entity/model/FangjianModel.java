package com.entity.model;

import com.entity.FangjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangjianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房间号
     */
    private String fangjianName;


    /**
     * 房间类型
     */
    private Integer fangjianTypes;


    /**
     * 所在区域
     */
    private String fangjianAddress;


    /**
     * 房间配置
     */
    private String fangjianPeizhi;


    /**
     * 房间图片
     */
    private String fangjianPhoto;


    /**
     * 价格/天
     */
    private Double fangjianNewMoney;


    /**
     * 房间状态
     */
    private Integer statusTypes;


    /**
     * 房间详情
     */
    private String fangjianContent;


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
	 * 获取：房间号
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 设置：房间号
	 */
    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 获取：房间类型
	 */
    public Integer getFangjianTypes() {
        return fangjianTypes;
    }


    /**
	 * 设置：房间类型
	 */
    public void setFangjianTypes(Integer fangjianTypes) {
        this.fangjianTypes = fangjianTypes;
    }
    /**
	 * 获取：所在区域
	 */
    public String getFangjianAddress() {
        return fangjianAddress;
    }


    /**
	 * 设置：所在区域
	 */
    public void setFangjianAddress(String fangjianAddress) {
        this.fangjianAddress = fangjianAddress;
    }
    /**
	 * 获取：房间配置
	 */
    public String getFangjianPeizhi() {
        return fangjianPeizhi;
    }


    /**
	 * 设置：房间配置
	 */
    public void setFangjianPeizhi(String fangjianPeizhi) {
        this.fangjianPeizhi = fangjianPeizhi;
    }
    /**
	 * 获取：房间图片
	 */
    public String getFangjianPhoto() {
        return fangjianPhoto;
    }


    /**
	 * 设置：房间图片
	 */
    public void setFangjianPhoto(String fangjianPhoto) {
        this.fangjianPhoto = fangjianPhoto;
    }
    /**
	 * 获取：价格/天
	 */
    public Double getFangjianNewMoney() {
        return fangjianNewMoney;
    }


    /**
	 * 设置：价格/天
	 */
    public void setFangjianNewMoney(Double fangjianNewMoney) {
        this.fangjianNewMoney = fangjianNewMoney;
    }
    /**
	 * 获取：房间状态
	 */
    public Integer getStatusTypes() {
        return statusTypes;
    }


    /**
	 * 设置：房间状态
	 */
    public void setStatusTypes(Integer statusTypes) {
        this.statusTypes = statusTypes;
    }
    /**
	 * 获取：房间详情
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }


    /**
	 * 设置：房间详情
	 */
    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
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
