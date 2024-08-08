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
 * 工资结算
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("gongzijiesuan")
public class GongzijiesuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzijiesuanEntity() {
		
	}
	
	public GongzijiesuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 岗位名称
	 */
					
	private String gangweimingcheng;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 底薪
	 */
					
	private Integer dixin;
	
	/**
	 * 绩效
	 */
					
	private Integer jixiao;
	
	/**
	 * 岗位补贴
	 */
					
	private Integer gangweibutie;
	
	/**
	 * 全勤奖
	 */
					
	private Integer quanqinjiang;
	
	/**
	 * 加班费
	 */
					
	private Integer jiabanfei;
	
	/**
	 * 扣绩效
	 */
					
	private Integer koujixiao;
	
	/**
	 * 其它扣款
	 */
					
	private Integer qitakoukuan;
	
	/**
	 * 实发工资
	 */
					
	private String shifagongzi;
	
	/**
	 * 工资备注
	 */
					
	private String gongzibeizhu;
	
	/**
	 * 部门账号
	 */
					
	private String bumenzhanghao;
	
	/**
	 * 部门名称
	 */
					
	private String bumenmingcheng;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setGangweimingcheng(String gangweimingcheng) {
		this.gangweimingcheng = gangweimingcheng;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getGangweimingcheng() {
		return gangweimingcheng;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：底薪
	 */
	public void setDixin(Integer dixin) {
		this.dixin = dixin;
	}
	/**
	 * 获取：底薪
	 */
	public Integer getDixin() {
		return dixin;
	}
	/**
	 * 设置：绩效
	 */
	public void setJixiao(Integer jixiao) {
		this.jixiao = jixiao;
	}
	/**
	 * 获取：绩效
	 */
	public Integer getJixiao() {
		return jixiao;
	}
	/**
	 * 设置：岗位补贴
	 */
	public void setGangweibutie(Integer gangweibutie) {
		this.gangweibutie = gangweibutie;
	}
	/**
	 * 获取：岗位补贴
	 */
	public Integer getGangweibutie() {
		return gangweibutie;
	}
	/**
	 * 设置：全勤奖
	 */
	public void setQuanqinjiang(Integer quanqinjiang) {
		this.quanqinjiang = quanqinjiang;
	}
	/**
	 * 获取：全勤奖
	 */
	public Integer getQuanqinjiang() {
		return quanqinjiang;
	}
	/**
	 * 设置：加班费
	 */
	public void setJiabanfei(Integer jiabanfei) {
		this.jiabanfei = jiabanfei;
	}
	/**
	 * 获取：加班费
	 */
	public Integer getJiabanfei() {
		return jiabanfei;
	}
	/**
	 * 设置：扣绩效
	 */
	public void setKoujixiao(Integer koujixiao) {
		this.koujixiao = koujixiao;
	}
	/**
	 * 获取：扣绩效
	 */
	public Integer getKoujixiao() {
		return koujixiao;
	}
	/**
	 * 设置：其它扣款
	 */
	public void setQitakoukuan(Integer qitakoukuan) {
		this.qitakoukuan = qitakoukuan;
	}
	/**
	 * 获取：其它扣款
	 */
	public Integer getQitakoukuan() {
		return qitakoukuan;
	}
	/**
	 * 设置：实发工资
	 */
	public void setShifagongzi(String shifagongzi) {
		this.shifagongzi = shifagongzi;
	}
	/**
	 * 获取：实发工资
	 */
	public String getShifagongzi() {
		return shifagongzi;
	}
	/**
	 * 设置：工资备注
	 */
	public void setGongzibeizhu(String gongzibeizhu) {
		this.gongzibeizhu = gongzibeizhu;
	}
	/**
	 * 获取：工资备注
	 */
	public String getGongzibeizhu() {
		return gongzibeizhu;
	}
	/**
	 * 设置：部门账号
	 */
	public void setBumenzhanghao(String bumenzhanghao) {
		this.bumenzhanghao = bumenzhanghao;
	}
	/**
	 * 获取：部门账号
	 */
	public String getBumenzhanghao() {
		return bumenzhanghao;
	}
	/**
	 * 设置：部门名称
	 */
	public void setBumenmingcheng(String bumenmingcheng) {
		this.bumenmingcheng = bumenmingcheng;
	}
	/**
	 * 获取：部门名称
	 */
	public String getBumenmingcheng() {
		return bumenmingcheng;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
