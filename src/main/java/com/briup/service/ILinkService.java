package com.briup.service;


import java.util.List;

import com.briup.bean.Link;
import com.briup.utils.CustomerException;

/**
 * 关于链接的相关操纵，service层
 * @author 可
 *
 */
public interface ILinkService {
	/**
	 * 保存和修改链接信息
	 * @param link
	 */
	void saveOrUpdateLink(Link link) throws CustomerException;
	
	/**
	 * 查询所有链接信息
	 * @param link
	 */
	List<Link> findAllLinks() throws CustomerException;
	/**
	 * 根据id查询链接信息
	 * @param link
	 */
	Link selectLink(Integer id)throws CustomerException;
	
	/**
	 * 根据链接名查询链接信息
	 * @param link
	 */
	List<Link> findLinksByName(String name)throws CustomerException;
	
	/**
	 * 根据id删除链接信息
	 * @param link
	 */
	void deleteLinkById(int id)throws CustomerException;
}
