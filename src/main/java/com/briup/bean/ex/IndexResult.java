package com.briup.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.bean.Link;

public class IndexResult implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<CategoryEx> categoryEx;
	private	List<Link> link;
	public List<CategoryEx> getCategoryEx() {
		return categoryEx;
	}
	public void setCategoryEx(List<CategoryEx> categoryEx) {
		this.categoryEx = categoryEx;
	}
	public List<Link> getLink() {
		return link;
	}
	public void setLink(List<Link> link) {
		this.link = link;
	}
	public IndexResult(List<CategoryEx> categoryEx, List<Link> link) {
		super();
		this.categoryEx = categoryEx;
		this.link = link;
	}
	public IndexResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
