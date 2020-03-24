package com.briup.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiParam;

public class Article implements Serializable {
	@ApiParam(value = "文章id内容",required = false)
    private Integer id;
    @ApiParam(value = "作者",required = true)
    private String author;
    @ApiParam(hidden = true)
    private Integer clicktimes;
    @ApiParam(value = "内容",required = true)
    private String content;
    @ApiParam(hidden = true)
    private Date publishdate;
    @ApiParam(value = "标题",required = true)
    private String title;
    @ApiParam(value = "模板id（外键）",required = true)
    private Integer categoryId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getClicktimes() {
        return clicktimes;
    }

    public void setClicktimes(Integer clicktimes) {
        this.clicktimes = clicktimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", author=").append(author);
        sb.append(", clicktimes=").append(clicktimes);
        sb.append(", content=").append(content);
        sb.append(", publishdate=").append(publishdate);
        sb.append(", title=").append(title);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}