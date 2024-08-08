package com.dao;

import com.entity.GangweimianshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GangweimianshiVO;
import com.entity.view.GangweimianshiView;


/**
 * 岗位面试
 * 
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface GangweimianshiDao extends BaseMapper<GangweimianshiEntity> {
	
	List<GangweimianshiVO> selectListVO(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
	
	GangweimianshiVO selectVO(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
	
	List<GangweimianshiView> selectListView(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);

	List<GangweimianshiView> selectListView(Pagination page,@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
	
	GangweimianshiView selectView(@Param("ew") Wrapper<GangweimianshiEntity> wrapper);
	

}
