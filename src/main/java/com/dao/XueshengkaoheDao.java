package com.dao;

import com.entity.XueshengkaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengkaoheVO;
import com.entity.view.XueshengkaoheView;


/**
 * 学生考核
 * 
 * @author 
 * @email 
 * @date 2024-04-06
 */
public interface XueshengkaoheDao extends BaseMapper<XueshengkaoheEntity> {
	
	List<XueshengkaoheVO> selectListVO(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
	
	XueshengkaoheVO selectVO(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
	
	List<XueshengkaoheView> selectListView(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);

	List<XueshengkaoheView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
	
	XueshengkaoheView selectView(@Param("ew") Wrapper<XueshengkaoheEntity> wrapper);
	

}
