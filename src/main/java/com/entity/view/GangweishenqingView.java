package com.entity.view;

import com.entity.GangweishenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 岗位申请
 * 后端返回视图实体辅助类
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("gangweishenqing")
public class GangweishenqingView  extends GangweishenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweishenqingView(){
	}
 
 	public GangweishenqingView(GangweishenqingEntity gangweishenqingEntity){
 	try {
			BeanUtils.copyProperties(this, gangweishenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
