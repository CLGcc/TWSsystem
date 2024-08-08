package com.dao;

import com.entity.GongzijiesuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzijiesuanVO;
import com.entity.view.GongzijiesuanView;


/**
 * 工资结算
 * 
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface GongzijiesuanDao extends BaseMapper<GongzijiesuanEntity> {
	
	List<GongzijiesuanVO> selectListVO(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
	
	GongzijiesuanVO selectVO(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
	
	List<GongzijiesuanView> selectListView(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);

	List<GongzijiesuanView> selectListView(Pagination page,@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
	
	GongzijiesuanView selectView(@Param("ew") Wrapper<GongzijiesuanEntity> wrapper);
	

}
