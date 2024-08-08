package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengkaoheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengkaoheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengkaoheView;


/**
 * 学生考核
 *
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface XueshengkaoheService extends IService<XueshengkaoheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengkaoheVO> selectListVO(Wrapper<XueshengkaoheEntity> wrapper);
   	
   	XueshengkaoheVO selectVO(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
   	
   	List<XueshengkaoheView> selectListView(Wrapper<XueshengkaoheEntity> wrapper);
   	
   	XueshengkaoheView selectView(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengkaoheEntity> wrapper);
   	

}

