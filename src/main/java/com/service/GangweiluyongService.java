package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweiluyongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweiluyongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweiluyongView;


/**
 * 岗位录用
 *
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface GangweiluyongService extends IService<GangweiluyongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweiluyongVO> selectListVO(Wrapper<GangweiluyongEntity> wrapper);
   	
   	GangweiluyongVO selectVO(@Param("ew") Wrapper<GangweiluyongEntity> wrapper);
   	
   	List<GangweiluyongView> selectListView(Wrapper<GangweiluyongEntity> wrapper);
   	
   	GangweiluyongView selectView(@Param("ew") Wrapper<GangweiluyongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweiluyongEntity> wrapper);
   	

}

