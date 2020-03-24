package com.briup.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.ArticleExample;
import com.briup.bean.Category;
import com.briup.bean.CategoryExample;
import com.briup.mapper.ArticleMapper;
import com.briup.mapper.CategoryMapper;
import com.briup.service.IArticleService;
import com.briup.utils.CustomerException;
import com.briup.utils.StatusCodeUtil;

/**
 * 实现文章相关管理的逻辑类
 * @author 可
 *
 */
@Service
public class ArticleServiceImpl implements IArticleService {
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private CategoryMapper categorymapper;
	@Override
	public void saveOrUpdateArticle(Article article) throws CustomerException {
		if(article == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		Category selectByPrimaryKey = categorymapper.selectByPrimaryKey(article.getCategoryId());
		if(selectByPrimaryKey==null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "没有此模块id");
		}
			if(article.getId() == null) {
			//需要额外添加两条数据
			article.setPublishdate(new Date());
			article.setClicktimes(0);
			articleMapper.insert(article);
		}else {
			Article selectArticle = articleMapper.selectByPrimaryKey(article.getId());
			article.setClicktimes(selectArticle.getClicktimes());
			article.setPublishdate(new Date());
			articleMapper.updateByPrimaryKey(article);
		}
	}

	@Override
	public void deleteArticleById(Integer id) throws CustomerException {
		articleMapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public List<Article> findArticleByCondition(String keyStr, String condition) throws CustomerException {
		/**
		 *分三种情况
		 * 1.没有添加任何条件，则查询所有文章
		 * 2.没有指定栏目，但指定了查询的关键字，则根据关键字查询满足条件的所有文章；
		 * 4.只指定栏目查询
		 * 3.指定栏目，同事指定查询的关键字，则根据栏目和关键字查询满足条件的文章。
		 */
		keyStr = keyStr==null? "": keyStr.trim();
		condition = condition==null? "": condition.trim();
		ArticleExample example = new ArticleExample();
		if("".equals(keyStr) && "".equals(condition)) {
			//情况1
			return articleMapper.selectByExample(example);
			
		}else if(!"".equals(keyStr) && "".equals(condition)) {
			//情况2
			example.createCriteria().andTitleLike("%"+keyStr+"%");
			return articleMapper.selectByExample(example);
			
		}else if(!"".equals(condition) && "".equals(keyStr)) {
			//情况3
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> categorie = categorymapper.selectByExample(categoryExample);
			//根据栏目信息，找到里面所有的文章
			if(categorie.size()>0) {
				example.createCriteria().andCategoryIdEqualTo(categorie.get(0).getId());
			}else {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "没有指定栏目：");
			}
			return articleMapper.selectByExample(example);
			
		}else{
			//情况4
			CategoryExample categoryExample = new CategoryExample();
			categoryExample.createCriteria().andNameEqualTo(condition);
			List<Category> categorie = categorymapper.selectByExample(categoryExample);
			//根据栏目信息，找到里面所有的文章
			example.createCriteria().andCategoryIdEqualTo(categorie.get(0).getId())
			.andTitleLike("%"+keyStr+"%");
			//example.or().andAuthorBetween(value1, value2)
			return articleMapper.selectByExample(example);
		}
	}

	@Override
	public Article findArticleById(Integer id) throws CustomerException {
		
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article==null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "系统错误--没有改id数据");
		}
		if(article.getClicktimes()==null) {
			article.setClicktimes(1);
		}else {
		article.setClicktimes(article.getClicktimes()+1);
		}
		articleMapper.updateByPrimaryKey(article);
		return article;
	}

}
