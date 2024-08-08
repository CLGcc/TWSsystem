package com.entity.view;

import com.entity.GongzijiesuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 工资结算
 * 后端返回视图实体辅助类
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("gongzijiesuan")
public class GongzijiesuanView  extends GongzijiesuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzijiesuanView(){
	}
 
 	public GongzijiesuanView(GongzijiesuanEntity gongzijiesuanEntity){
 	try {
			BeanUtils.copyProperties(this, gongzijiesuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
