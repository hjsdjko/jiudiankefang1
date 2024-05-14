package com.entity.view;

import com.entity.FangjianLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房间留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangjian_liuyan")
public class FangjianLiuyanView extends FangjianLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fangjian
			/**
			* 房间号
			*/
			private String fangjianName;
			/**
			* 房间类型
			*/
			private Integer fangjianTypes;
				/**
				* 房间类型的值
				*/
				private String fangjianValue;
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
				* 房间状态的值
				*/
				private String statusValue;
			/**
			* 房间详情
			*/
			private String fangjianContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FangjianLiuyanView() {

	}

	public FangjianLiuyanView(FangjianLiuyanEntity fangjianLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, fangjianLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set fangjian
					/**
					* 获取： 房间号
					*/
					public String getFangjianName() {
						return fangjianName;
					}
					/**
					* 设置： 房间号
					*/
					public void setFangjianName(String fangjianName) {
						this.fangjianName = fangjianName;
					}
					/**
					* 获取： 房间类型
					*/
					public Integer getFangjianTypes() {
						return fangjianTypes;
					}
					/**
					* 设置： 房间类型
					*/
					public void setFangjianTypes(Integer fangjianTypes) {
						this.fangjianTypes = fangjianTypes;
					}


						/**
						* 获取： 房间类型的值
						*/
						public String getFangjianValue() {
							return fangjianValue;
						}
						/**
						* 设置： 房间类型的值
						*/
						public void setFangjianValue(String fangjianValue) {
							this.fangjianValue = fangjianValue;
						}
					/**
					* 获取： 所在区域
					*/
					public String getFangjianAddress() {
						return fangjianAddress;
					}
					/**
					* 设置： 所在区域
					*/
					public void setFangjianAddress(String fangjianAddress) {
						this.fangjianAddress = fangjianAddress;
					}
					/**
					* 获取： 房间配置
					*/
					public String getFangjianPeizhi() {
						return fangjianPeizhi;
					}
					/**
					* 设置： 房间配置
					*/
					public void setFangjianPeizhi(String fangjianPeizhi) {
						this.fangjianPeizhi = fangjianPeizhi;
					}
					/**
					* 获取： 房间图片
					*/
					public String getFangjianPhoto() {
						return fangjianPhoto;
					}
					/**
					* 设置： 房间图片
					*/
					public void setFangjianPhoto(String fangjianPhoto) {
						this.fangjianPhoto = fangjianPhoto;
					}
					/**
					* 获取： 价格/天
					*/
					public Double getFangjianNewMoney() {
						return fangjianNewMoney;
					}
					/**
					* 设置： 价格/天
					*/
					public void setFangjianNewMoney(Double fangjianNewMoney) {
						this.fangjianNewMoney = fangjianNewMoney;
					}
					/**
					* 获取： 房间状态
					*/
					public Integer getStatusTypes() {
						return statusTypes;
					}
					/**
					* 设置： 房间状态
					*/
					public void setStatusTypes(Integer statusTypes) {
						this.statusTypes = statusTypes;
					}


						/**
						* 获取： 房间状态的值
						*/
						public String getStatusValue() {
							return statusValue;
						}
						/**
						* 设置： 房间状态的值
						*/
						public void setStatusValue(String statusValue) {
							this.statusValue = statusValue;
						}
					/**
					* 获取： 房间详情
					*/
					public String getFangjianContent() {
						return fangjianContent;
					}
					/**
					* 设置： 房间详情
					*/
					public void setFangjianContent(String fangjianContent) {
						this.fangjianContent = fangjianContent;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
