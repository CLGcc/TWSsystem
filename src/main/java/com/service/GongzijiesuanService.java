package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzijiesuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongzijiesuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzijiesuanView;


/**
 * 工资结算
 *
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface GongzijiesuanService extends IService<GongzijiesuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzijiesuanVO> selectListVO(Wrapper<GongzijiesuanEntity> wrapper);
   	
   	GongzijiesuanVO selectVO(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
   	
   	List<GongzijiesuanView> selectListView(Wrapper<GongzijiesuanEntity> wrapper);
   	
   	GongzijiesuanView selectView(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzijiesuanEntity> wrapper);
   	

}

