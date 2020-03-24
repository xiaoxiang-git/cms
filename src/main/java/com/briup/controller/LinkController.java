package com.briup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Link;
import com.briup.service.ILinkService;
import com.briup.utils.CustomerException;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 与链接相关的和前端交互的web层
 * @author 可
 *
 */

@RestController
@Api(tags = {"Link接口"})
public class LinkController {
	
	@Autowired
	private ILinkService linkService;
	
	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> addLink(Link link){
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		}catch(CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误:"+e.getMessage());
		}
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("修改链接")
	public Message<String> updateLink(Link link){
		try {
			linkService.saveOrUpdateLink(link);
			return MessageUtil.success();
		}catch(CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误:"+e.getMessage());
		}
	}
	
	
	@GetMapping("/selectLink")
	@ApiOperation("id查询链接")
	public Message<Link> selectLink(Integer id){
			Link link = linkService.selectLink(id);
			return MessageUtil.success(link);
	}
	
	@GetMapping("/selectLinks")
	@ApiOperation("查询所有链接")
	public Message<List<Link>> selectLinks(){
		List<Link> list = linkService.findAllLinks();
		return MessageUtil.success(list);
	}
	
	@GetMapping("/selectLinkByName")
	@ApiOperation("根据名字查询所有链接")
	public Message<List<Link>> selectLinkByName(String name){
		 return MessageUtil.success(linkService.findLinksByName(name));
	}
	
	@GetMapping("/deleteLinkById")
	@ApiOperation("根据id删除链接")
	public Message<String> deleteLink(Integer id) {
		linkService.deleteLinkById(id);
		return MessageUtil.success();
	}
}
