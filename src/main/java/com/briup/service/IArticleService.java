package com.briup.service;

import java.util.List;

import com.briup.bean.Article;
import com.briup.utils.CustomerException;

/**
 * 文章相关类容的service接口
 * @author 可
 *
 */
public interface IArticleService {
	/**
	 *新增或修改文章
	 */
	void saveOrUpdateArticle(Article article)throws CustomerException;
	/**
	 *删除文章
	 */
	void deleteArticleById(Integer id)throws CustomerException;
	
	/**
	 * @param keyStr 
	 * @param condition
	 * @return
	 * @throws CustomerException
	 */
	List<Article> findArticleByCondition(String keyStr,String condition)throws CustomerException;
	/**
	 *根据id查询文章
	 */
	Article findArticleById(Integer id)throws CustomerException;
	

}
