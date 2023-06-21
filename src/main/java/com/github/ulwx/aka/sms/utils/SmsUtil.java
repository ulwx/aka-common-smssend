package com.github.ulwx.aka.sms.utils;

import com.github.ulwx.aka.sms.enums.CodeEnum;
import com.github.ulwx.aka.sms.bean.SmsConfig;
import com.github.ulwx.aka.webmvc.BeanGet;
import com.ulwx.tool.ArrayUtils;
import com.ulwx.tool.HttpUtils;
import com.ulwx.tool.StringUtils;
import org.apache.log4j.Logger;

import java.net.URLEncoder;

public class SmsUtil {

    private static Logger logger = Logger.getLogger(SmsUtil.class);

    /**
     * 消息发送方法
     * @param type  发送短信的类型：
     *              1---行业验证类短信（对接验证码 通知类短信的）
     *              2---营销类短信（发营销推广类的短信）
     *              3---行业非验证类短信（没有验证码 通知类短信的）
     * @param numbers  发送的电话，最大500个
     *               如果发送多个电话需要用逗号隔开，如：13888888888,13999999999
     * @param msgContent 内容。
     */
    public static Integer sendMsg(String type,String numbers,String msgContent){
        return send(type,numbers,msgContent);
    }

    private static Integer send(String type,String numbers,String msgContent){
        String result = "-1";
        StringBuffer urlSb = new StringBuffer();
        Integer resultMap = 1;

        try {
            //缓存获取
            SmsConfig smsConfig = BeanGet.getBean(SmsCacheService.class).getSmsConfig(type);
            if(smsConfig!=null){
                if("鼎汉".equals(smsConfig.getCommpany())){
                	String blackStr= StringUtils.trim(smsConfig.getBlackPhone());
                	String[] strs=blackStr.split(",");
                	if(ArrayUtils.contains(strs, numbers)) {
                		return -1;
                	}
                    logger.info("请求鼎汉短信接口开始------------------------------》");
                    urlSb.append(smsConfig.getUrl()).append("/Message.sv?method=sendMsg");
                    urlSb.append("&userCode=").append(smsConfig.getUserCode());
                    urlSb.append("&userPwd=").append(smsConfig.getUserPwd());
                    urlSb.append("&numbers=").append(numbers);
                    msgContent = "【"+smsConfig.getSmsPrex()
                    		+ "】" + msgContent;
                    if(!StringUtils.isEmpty(smsConfig.getFilter())){
                        String[] filter = smsConfig.getFilter().split(",");
                        for(String f : filter){
                            msgContent = msgContent.replaceAll(f,"");
                        }
                    }
                    urlSb.append("&msgContent=").append(URLEncoder.encode(msgContent, "utf-8"));
                    urlSb.append("&charset=").append("utf-8");
                    String fullUrlStr = urlSb.toString();
                    logger.info("短信发送方法http的url：" + fullUrlStr);
                    result= HttpUtils.get(fullUrlStr, "utf-8");
                }

            }else{
                logger.error("短信接口没有该type类型");
                return -1;
            }



            logger.info("短信发送http发送返回结果：" + result);
            String resultCode = "1";
            resultCode = result.indexOf(",")!=-1?result.substring(0,result.indexOf(",")):result;
            String resultMsg = CodeEnum.getMsg(resultCode);
            resultMap = "0".equals(resultCode)||"1".equals(resultCode)?0:1;
            logger.info("短信发送http发送返回结果：" + result);
            logger.info("短信发送http发送返回结果转换：结果码：" + resultCode + "结果信息：" + resultMsg);
            return resultMap;
        } catch (Exception e) {
            logger.error("短信发送发送网络异常，原因是：" + e.getMessage());
            return 1;
        }
    }

   
}
