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


import com.dao.GangweiluyongDao;
import com.entity.GangweiluyongEntity;
import com.service.GangweiluyongService;
import com.entity.vo.GangweiluyongVO;
import com.entity.view.GangweiluyongView;

@Service("gangweiluyongService")
public class GangweiluyongServiceImpl extends ServiceImpl<GangweiluyongDao, GangweiluyongEntity> implements GangweiluyongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweiluyongEntity> page = this.selectPage(
                new Query<GangweiluyongEntity>(params).getPage(),
                new EntityWrapper<GangweiluyongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweiluyongEntity> wrapper) {
		  Page<GangweiluyongView> page =new Query<GangweiluyongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweiluyongVO> selectListVO(Wrapper<GangweiluyongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweiluyongVO selectVO(Wrapper<GangweiluyongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweiluyongView> selectListView(Wrapper<GangweiluyongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweiluyongView selectView(Wrapper<GangweiluyongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
