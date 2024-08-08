package com.entity.view;

import com.entity.GangweileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 岗位类型
 * 后端返回视图实体辅助类
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("gangweileixing")
public class GangweileixingView  extends GangweileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweileixingView(){
	}
 
 	public GangweileixingView(GangweileixingEntity gangweileixingEntity){
 	try {
			BeanUtils.copyProperties(this, gangweileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
