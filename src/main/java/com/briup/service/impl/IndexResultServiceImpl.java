package com.briup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Link;
import com.briup.bean.ex.CategoryEx;
import com.briup.bean.ex.IndexResult;
import com.briup.mapper.CategoryMapper;
import com.briup.mapper.LinkMapper;
import com.briup.service.IArticleService;
import com.briup.service.ICategoryService;
import com.briup.service.IIndexResultService;
import com.briup.service.ILinkService;
import com.briup.utils.CustomerException;

/**
 * 查询首页的所有数据实现类
 * @author 可
 *
 */
@Service
public class IndexResultServiceImpl implements IIndexResultService {
	
	//关联超链接的service层接口
	
	
	@Autowired
	private ILinkService linkService;
	@Autowired
	private ICategoryService categoryService;
	@Override
	public IndexResult findIndexAllResult() throws CustomerException {
		
		
		IndexResult indexResult = new IndexResult();
		
		List<Link> links = linkService.findAllLinks();
		indexResult.setLink(links);
		List<CategoryEx> categoryEx = categoryService.findAllCategoryEx();
		indexResult.setCategoryEx(categoryEx);
		
		return indexResult;
	}

}
