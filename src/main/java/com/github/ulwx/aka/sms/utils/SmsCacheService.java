package com.github.ulwx.aka.sms.utils;

import com.github.ulwx.aka.sms.bean.SmsConfig;
import com.github.ulwx.aka.sms.dao.SmsConfigDAO;
import com.github.ulwx.aka.webmvc.AkaServiceSupport;
import com.ulwx.tool.cache.CacheUtils;
import org.apache.log4j.Logger;

/**
 * 缓存首页数据
 */
public class SmsCacheService extends AkaServiceSupport {

     private static Logger logger = Logger.getLogger(SmsCacheService.class);
     /**
      * 鼎汉配置信息
      * @param  type  类型：1-行业  2-营销 3-行业非验证类
      * @return
      */
     public  SmsConfig getSmsConfig(String type) {
         SmsConfig smsConfig = null;
         smsConfig = getConfig(type,"smsConfigDataType"+type);
         return smsConfig;
     }

    public  SmsConfig getConfig(String type,String key){
        try {

            SmsConfig smsConfigData=CacheUtils.get(SmsConfig.class.getName());
            if(smsConfigData==null){
                smsConfigData = this.beanGet.bean(SmsConfigDAO.class).getSmsConfig(type);
            }else{
                CacheUtils.set(SmsConfig.class.getName(), smsConfigData,60*60*4);
            }
            if (smsConfigData == null) {
                throw new Exception("没有查询到短信配置信息！");
            } else {
                return smsConfigData;
            }
        } catch (Exception e) {
            logger.error( e+"",e);
            return null;
        }
    }

}
