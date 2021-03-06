package com.briup.mapper.ex;

import java.util.List;

import com.briup.bean.ex.CategoryEx;

/**
 * 处理  查询栏目及其包含的文章信息
 * @author 可
 *
 */
public interface CategoryExMapper {
	
	/**
	 * 实现查询所有栏目及其包含的文章信息
	 * @return
	 */
	List<CategoryEx> findAllCategoryExs();
	
	
	/**
	 * 通过id查询对应栏目及其包含的信息
	 * @param id
	 * @return
	 */
	CategoryEx findCategoryExById(Integer id);
}
