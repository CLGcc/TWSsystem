package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweimianshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweimianshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweimianshiView;


/**
 * 岗位面试
 *
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface GangweimianshiService extends IService<GangweimianshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweimianshiVO> selectListVO(Wrapper<GangweimianshiEntity> wrapper);
   	
   	GangweimianshiVO selectVO(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
   	
   	List<GangweimianshiView> selectListView(Wrapper<GangweimianshiEntity> wrapper);
   	
   	GangweimianshiView selectView(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweimianshiEntity> wrapper);
   	

}

