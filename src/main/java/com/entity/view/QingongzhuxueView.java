package com.entity.view;

import com.entity.QingongzhuxueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 勤工助学
 * 后端返回视图实体辅助类
 * @author 
 * @email 
 * @date 2024-04-06
 */
@TableName("qingongzhuxue")
public class QingongzhuxueView  extends QingongzhuxueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QingongzhuxueView(){
	}
 
 	public QingongzhuxueView(QingongzhuxueEntity qingongzhuxueEntity){
 	try {
			BeanUtils.copyProperties(this, qingongzhuxueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
