package com.site.blog.service;

import com.site.blog.entity.BlogTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.site.blog.entity.BlogTagCount;

import java.util.List;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author: 北易航
 */
public interface BlogTagService extends IService<BlogTag> {

    List<BlogTagCount> getBlogTagCountForIndex();

    boolean clearTag(Integer tagId);

}
