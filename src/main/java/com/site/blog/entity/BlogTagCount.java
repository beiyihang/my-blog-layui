package com.site.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/*
 *博客评论用户属性
 * @author: 北易航
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogTagCount {
    private Integer tagId;

    private String tagName;

    private long tagCount;



}
