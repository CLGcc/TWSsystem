package com.entity.view;

import com.entity.XueshengkaoheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生考核
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("xueshengkaohe")
public class XueshengkaoheView  extends XueshengkaoheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengkaoheView(){
	}
 
 	public XueshengkaoheView(XueshengkaoheEntity xueshengkaoheEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengkaoheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
