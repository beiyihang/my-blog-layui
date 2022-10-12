package com.site.blog.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: my-blog
 * @classname: DateUtils
 * @description:
 * @author: 北易航
 **/
public class DateUtils {

    /**
     * 获得本地当前时间
     * @param
     * @return java.sql.Timestamp
     * @date
     */
    public static Timestamp getLocalCurrentDate(){
        return new Timestamp(new Date().getTime());
    }
}
