package com.site.blog.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 前台博客分页条件
 * @author 北易航
 * @create
 */
@Data
@Accessors(chain = true)
public class BlogPageCondition {

    private Integer pageNum;

    private Integer pageSize;

    private String keyword;

    private String pageName;

    private String tagId;

    private String categoryName;

}
