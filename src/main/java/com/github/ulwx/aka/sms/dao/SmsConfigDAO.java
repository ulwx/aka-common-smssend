package com.github.ulwx.aka.sms.dao;

import com.github.ulwx.aka.dbutils.spring.multids.AkaDS;
import com.github.ulwx.aka.dbutils.tool.MD;
import com.github.ulwx.aka.sms.bean.SmsConfig;
import com.github.ulwx.aka.webmvc.AkaDaoSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * 鼎汉DAO
 * @author Brain
 */
@AkaDS("${aka.smssend.ds}")
public class SmsConfigDAO extends AkaDaoSupport {
    public  SmsConfig getSmsConfig(String type) throws Exception {
        Map<String, Object> args = new HashMap<>();
        args.put("type", type);
        return this.getTemplate().queryOne(SmsConfig.class, MD.md(), args);
    }
    
    public static void main(String[] args) throws Exception{

		
	}


}
