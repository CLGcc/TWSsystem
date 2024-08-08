package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GangweimianshiDao;
import com.entity.GangweimianshiEntity;
import com.service.GangweimianshiService;
import com.entity.vo.GangweimianshiVO;
import com.entity.view.GangweimianshiView;

@Service("gangweimianshiService")
public class GangweimianshiServiceImpl extends ServiceImpl<GangweimianshiDao, GangweimianshiEntity> implements GangweimianshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweimianshiEntity> page = this.selectPage(
                new Query<GangweimianshiEntity>(params).getPage(),
                new EntityWrapper<GangweimianshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweimianshiEntity> wrapper) {
		  Page<GangweimianshiView> page =new Query<GangweimianshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweimianshiVO> selectListVO(Wrapper<GangweimianshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweimianshiVO selectVO(Wrapper<GangweimianshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweimianshiView> selectListView(Wrapper<GangweimianshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweimianshiView selectView(Wrapper<GangweimianshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
