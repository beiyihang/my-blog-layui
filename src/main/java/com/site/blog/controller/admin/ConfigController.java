package com.site.blog.controller.admin;

import com.site.blog.constants.HttpStatusEnum;
import com.site.blog.pojo.dto.AjaxResultPage;
import com.site.blog.pojo.dto.Result;
import com.site.blog.entity.BlogConfig;
import com.site.blog.service.BlogConfigService;
import com.site.blog.util.DateUtils;
import com.site.blog.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: blog配置controller
 */
@Controller
@RequestMapping("/admin")
public class ConfigController {

    @Autowired
    private BlogConfigService blogConfigService;

    /**
     * 跳转系统配置界面
     * @return java.lang.String
     */
    @GetMapping("/v1/blogConfig")
    public String gotoBlogConfig(){
        return "adminLayui/sys-edit";
    }

    /**
     * 返回系统配置信息
     * @param
     * @return com.site.blog.pojo.dto.AjaxResultPage<com.site.blog.entity.BlogConfig>
     */
    @ResponseBody
    @GetMapping("/v1/blogConfig/list")
    public AjaxResultPage<BlogConfig> getBlogConfig(){
        AjaxResultPage<BlogConfig> ajaxResultPage = new AjaxResultPage<>();
        List<BlogConfig> list = blogConfigService.list();
        if (CollectionUtils.isEmpty(list)){
            ajaxResultPage.setCode(500);
            return ajaxResultPage;
        }
        ajaxResultPage.setData(blogConfigService.list());
        return ajaxResultPage;
    }

    /**
     * 修改系统信息
     * @param blogConfig
     * @return com.site.blog.pojo.dto.Result
     */
    @ResponseBody
    @PostMapping("/v1/blogConfig/edit")
    public Result<String> updateBlogConfig(BlogConfig blogConfig){
        blogConfig.setUpdateTime(DateUtils.getLocalCurrentDate());
        boolean flag = blogConfigService.updateById(blogConfig);
        if (flag){
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK);
        }else{
            return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/v1/blogConfig/add")
    public String addBlogConfig(){
        return "adminLayui/sys-add";
    }

    /**
     * 新增系统信息项
     * @param blogConfig
     * @return com.site.blog.pojo.dto.Result
     */
    @ResponseBody
    @PostMapping("/v1/blogConfig/add")
    public Result<String> addBlogConfig(BlogConfig blogConfig){
        blogConfig.setCreateTime(DateUtils.getLocalCurrentDate());
        blogConfig.setUpdateTime(DateUtils.getLocalCurrentDate());
        boolean flag = blogConfigService.save(blogConfig);
        if (flag){
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK);
        }else{
            return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 删除配置信息项
     * @param configField
     * @return com.site.blog.pojo.dto.Result
     */
    @ResponseBody
    @PostMapping("/v1/blogConfig/del")
    public Result<String> delBlogConfig(@RequestParam String configField){
        boolean flag = blogConfigService.removeById(configField);
        if (flag){
            return ResultGenerator.getResultByHttp(HttpStatusEnum.OK);
        }else{
            return ResultGenerator.getResultByHttp(HttpStatusEnum.INTERNAL_SERVER_ERROR);
        }
    }
}
