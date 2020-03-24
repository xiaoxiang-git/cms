package com.briup.service;

import com.briup.bean.ex.IndexResult;
import com.briup.utils.CustomerException;

/**
 * 首页数据管理的service层接口
 * @author 可
 *
 */
public interface IIndexResultService {
	/**
	 * 查询首页需要的所有数据
	 * @return
	 * @throws CustomerException
	 */
	IndexResult findIndexAllResult() throws CustomerException;
	
	
}
