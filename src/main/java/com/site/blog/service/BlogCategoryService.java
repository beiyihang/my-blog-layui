package com.site.blog.service;

import com.site.blog.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 博客分类 服务类
 * </p>
 *
 * @author: 北易航
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    public boolean clearCategory(BlogCategory blogCategory);

}
