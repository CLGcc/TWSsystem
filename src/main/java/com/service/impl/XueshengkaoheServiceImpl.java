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


import com.dao.XueshengkaoheDao;
import com.entity.XueshengkaoheEntity;
import com.service.XueshengkaoheService;
import com.entity.vo.XueshengkaoheVO;
import com.entity.view.XueshengkaoheView;

@Service("xueshengkaoheService")
public class XueshengkaoheServiceImpl extends ServiceImpl<XueshengkaoheDao, XueshengkaoheEntity> implements XueshengkaoheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengkaoheEntity> page = this.selectPage(
                new Query<XueshengkaoheEntity>(params).getPage(),
                new EntityWrapper<XueshengkaoheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengkaoheEntity> wrapper) {
		  Page<XueshengkaoheView> page =new Query<XueshengkaoheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengkaoheVO> selectListVO(Wrapper<XueshengkaoheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengkaoheVO selectVO(Wrapper<XueshengkaoheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengkaoheView> selectListView(Wrapper<XueshengkaoheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengkaoheView selectView(Wrapper<XueshengkaoheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
