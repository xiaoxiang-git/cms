package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.ex.CategoryEx;
import com.briup.utils.CustomerException;

/**
 * 目录栏目相关的service层
 * @author 可
 *
 */
public interface ICategoryService { 
	/**
	 *查询所有的栏目
	 */
	 List<Category> findAllCategorys()throws CustomerException;
	
	/**
	 *添加或修改栏目信息
	 */
	 void saveOrUpdateCategory(Category category)throws CustomerException;
	
	/**
	 *根据id删除栏目信息
	 */
	 void deleteCategoryById(Integer id)throws CustomerException;
	
	/**
	 *根据id找指定栏目信息
	 */
	 Category findCategoryById(Integer id)throws CustomerException;
	 
	/**
	 *查询栏目信息并且级联包含的文章信息
	 */
	 List<CategoryEx> findAllCategoryEx() throws CustomerException;
	 
	 List<Article> ShowArticle(String name) throws CustomerException;
	 
	 /**
	  * 查询栏目及其包含的文章的所有数据
	 * @param id
	 * @return
	 * @throws CustomerException
	 */
	CategoryEx findCategoryExById(Integer id) throws CustomerException;
}
