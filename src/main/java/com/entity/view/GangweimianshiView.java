package com.entity.view;

import com.entity.GangweimianshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 岗位面试
 * 后端返回视图实体辅助类
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("gangweimianshi")
public class GangweimianshiView  extends GangweimianshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweimianshiView(){
	}
 
 	public GangweimianshiView(GangweimianshiEntity gangweimianshiEntity){
 	try {
			BeanUtils.copyProperties(this, gangweimianshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
