package com.dao;

import com.entity.QingongzhuxueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QingongzhuxueVO;
import com.entity.view.QingongzhuxueView;


/**
 * 勤工助学
 * 
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface QingongzhuxueDao extends BaseMapper<QingongzhuxueEntity> {
	
	List<QingongzhuxueVO> selectListVO(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
	
	QingongzhuxueVO selectVO(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
	
	List<QingongzhuxueView> selectListView(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);

	List<QingongzhuxueView> selectListView(Pagination page,@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
	
	QingongzhuxueView selectView(@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QingongzhuxueEntity> wrapper);



}
