package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.ArticleExample.Criteria;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.bean.ex.CategoryEx;
import com.briup.mapper.ArticleMapper;
import com.briup.mapper.CategoryMapper;
import com.briup.mapper.ex.CategoryExMapper;
import com.briup.service.ICategoryService;
import com.briup.utils.CustomerException;
import com.briup.utils.StatusCodeUtil;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryMapper categorymapper;
	
	@Autowired
	private ArticleMapper articlemapper;
	@Autowired
	private CategoryExMapper categoryExMapper;
	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		return categorymapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if(category == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE,"参数为空");
		}
		if(category.getId() == null) {
			//先找出表中存在的
			CategoryExample example = new CategoryExample();
			List<Category> listCategory = categorymapper.selectByExample(example);
			if(listCategory.size()==0) {
				categorymapper.insert(category);
			}else {
			for (Category category2 : listCategory) {
				if(category.getCode()==category2.getCode()||category2.getName().equals(category.getName())){
					throw new CustomerException(StatusCodeUtil.SAVEERROR_CODE,"已有参数");
				}
			}
				categorymapper.insert(category);
			}
		}else {
			categorymapper.updateByPrimaryKey(category);
		}
	}

	@Override
	public void deleteCategoryById(Integer id) throws CustomerException {
		//栏中文章先全部删掉
		 ArticleExample example = new ArticleExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andCategoryIdEqualTo(id);
		 articlemapper.deleteByExample(example);
		
		 categorymapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category findCategoryById(Integer id) throws CustomerException {
		
		return categorymapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {
		
		return categoryExMapper.findAllCategoryExs();
	}

	@Override
	public List<Article> ShowArticle(String name) throws CustomerException {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andNameEqualTo(name);
		List<Category> category = categorymapper.selectByExample(example);
		List<CategoryEx> CategoryExs = categoryExMapper.findAllCategoryExs();
		if(category.size()==0) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE,"系统错误");
		}
		Category categoryRell = category.get(0);
		
		for (CategoryEx categoryEx : CategoryExs) {
			if(categoryEx.getName().equals(categoryRell.getName())) {
				return categoryEx.getArticles();
			}
		}
		return null;
	}

	@Override
	public CategoryEx findCategoryExById(Integer id) throws CustomerException {
		
		return categoryExMapper.findCategoryExById(id);
	}

}
