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


import com.dao.GongzijiesuanDao;
import com.entity.GongzijiesuanEntity;
import com.service.GongzijiesuanService;
import com.entity.vo.GongzijiesuanVO;
import com.entity.view.GongzijiesuanView;

@Service("gongzijiesuanService")
public class GongzijiesuanServiceImpl extends ServiceImpl<GongzijiesuanDao, GongzijiesuanEntity> implements GongzijiesuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzijiesuanEntity> page = this.selectPage(
                new Query<GongzijiesuanEntity>(params).getPage(),
                new EntityWrapper<GongzijiesuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzijiesuanEntity> wrapper) {
		  Page<GongzijiesuanView> page =new Query<GongzijiesuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GongzijiesuanVO> selectListVO(Wrapper<GongzijiesuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongzijiesuanVO selectVO(Wrapper<GongzijiesuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongzijiesuanView> selectListView(Wrapper<GongzijiesuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzijiesuanView selectView(Wrapper<GongzijiesuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
