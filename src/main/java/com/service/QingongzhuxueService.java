package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QingongzhuxueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QingongzhuxueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QingongzhuxueView;


/**
 * 勤工助学
 *
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface QingongzhuxueService extends IService<QingongzhuxueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingongzhuxueVO> selectListVO(Wrapper<QingongzhuxueEntity> wrapper);
   	
   	QingongzhuxueVO selectVO(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
   	
   	List<QingongzhuxueView> selectListView(Wrapper<QingongzhuxueEntity> wrapper);
   	
   	QingongzhuxueView selectView(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingongzhuxueEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QingongzhuxueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QingongzhuxueEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QingongzhuxueEntity> wrapper);



}

