package com.site.blog.service;

import com.site.blog.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.site.blog.entity.BlogConfig;

/**
 * <p>
 * 后台管理员信息表 服务类
 * </p>
 *
 * @author: 北易航
 */
public interface AdminUserService extends IService<AdminUser> {
    
    boolean validatePassword(Integer userId,String oldPwd);

    boolean updateUserInfo(AdminUser adminUser);

}
