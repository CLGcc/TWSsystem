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


import com.dao.QingongzhuxueDao;
import com.entity.QingongzhuxueEntity;
import com.service.QingongzhuxueService;
import com.entity.vo.QingongzhuxueVO;
import com.entity.view.QingongzhuxueView;

@Service("qingongzhuxueService")
public class QingongzhuxueServiceImpl extends ServiceImpl<QingongzhuxueDao, QingongzhuxueEntity> implements QingongzhuxueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingongzhuxueEntity> page = this.selectPage(
                new Query<QingongzhuxueEntity>(params).getPage(),
                new EntityWrapper<QingongzhuxueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingongzhuxueEntity> wrapper) {
		  Page<QingongzhuxueView> page =new Query<QingongzhuxueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QingongzhuxueVO> selectListVO(Wrapper<QingongzhuxueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QingongzhuxueVO selectVO(Wrapper<QingongzhuxueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QingongzhuxueView> selectListView(Wrapper<QingongzhuxueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingongzhuxueView selectView(Wrapper<QingongzhuxueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QingongzhuxueEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QingongzhuxueEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QingongzhuxueEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
