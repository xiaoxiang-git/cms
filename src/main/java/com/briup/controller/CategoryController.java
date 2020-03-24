package com.briup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.ex.CategoryEx;
import com.briup.service.ICategoryService;
import com.briup.service.impl.CategoryServiceImpl;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = {"栏目"})
public class CategoryController {
	
	@Autowired
	private ICategoryService CategoryServiceImpl;
	
	@PostMapping("/saveOrUpdateLink")
	@ApiOperation("增加|更新栏目")
	public Message<String> saveOrUpdateLink(Category category){
		try {
			CategoryServiceImpl.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE,"系统错误："+e.getMessage());
		}
	}
	@GetMapping("/findAllCategorys")
	@ApiOperation("查找所有")
	public Message<List<Category>> findAllCategorys(){
	   	return MessageUtil.success(CategoryServiceImpl.findAllCategorys());
	}
	
	@GetMapping("/findCategoryById")
	@ApiOperation("id查找")
	public Message<Category> findCategoryById(Integer id){
		return MessageUtil.success(CategoryServiceImpl.findCategoryById(id));
	}
	
	@GetMapping("/deleteCategoryById")
	@ApiOperation("id删除")
	public Message<String> deleteCategoryById(Integer id){
		CategoryServiceImpl.deleteCategoryById(id);
		return MessageUtil.success();
	}
	
	@GetMapping("/ShowArticle")
	@ApiOperation("栏目展示")
	public Message<List<Article>> showArticle(String name){
		return MessageUtil.success(CategoryServiceImpl.ShowArticle(name));
	}
	
	@GetMapping("/findCategoryExById")
	@ApiOperation("根据栏目id查找栏目及其包含子栏目的信息")
	public Message<CategoryEx> findCategoryExById(Integer id){
		return MessageUtil.success(CategoryServiceImpl.findCategoryExById(id));
	}

}
