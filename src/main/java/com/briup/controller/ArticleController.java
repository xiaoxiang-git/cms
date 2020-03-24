package com.briup.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.service.IArticleService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 文章相关信息的controller
 * @author 可
 *
 */
@RestController
@Api(tags = {"文章相关接口"})
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@PostMapping("/saveArticle")
	@ApiOperation("添加")
	public Message<String> saveArticle(Article article) {
		try {
			articleService.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	@PostMapping("/updateArticle")
	@ApiOperation("更新")
	public Message<String> updateArticle(Article article) {
		try {
			articleService.saveOrUpdateArticle(article);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	}
	@GetMapping("/deleteArticle")
	@ApiOperation("根据id删文章")
	public Message<String> deleteArticle(Integer id) {
		articleService.deleteArticleById(id);
		return MessageUtil.success();
	}
	@GetMapping("/findAriticleByCondition")
	@ApiOperation("根据条件查询文章")
	public Message<List<Article>> getArticleByCondition(String keyStr,String condition){
		List<Article> list;
		try {
			list = articleService.findArticleByCondition( keyStr, condition);
			return MessageUtil.success(list);
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误："+e.getMessage());
		}
	} 
	@GetMapping("/findAriticleById")
	@ApiOperation("根据id查询文章")
	public Message<Article> getArticleById(Integer id){
		Article article = articleService.findArticleById(id);
		return MessageUtil.success(article);
	}
}
