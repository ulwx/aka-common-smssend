package com.github.ulwx.aka.sms.enums;
import com.ulwx.tool.StringUtils;

public enum CodeEnum {
    sucXw("0", "玄武操作成功"),
    sucDh("1", "鼎汉操作成功"),
    err1002("-1002", "内部错误（半角关键符号、编码错误等）"),
    err1003("-1003", "用户账号或密码错误"),
    err1004("-1004","用户状态错误"),
    err1005("-1005","余额不足"),
    err1006("-1006","保留"),
    err1007("-1007","号码错误"),
    err1008("-1008","发送短信内容错误"),
    err1009("-1009","网络异常"),
    err1010("-1010","参数错误"),
    err1011("-1011","发送功能关闭"),
    err1012("-1012","访问频率太快"),
    err1013("-1013","未开通回执及上行功能"),
    err1014("-1014","定时时间早于提交时间"),
    err1015("-1015","选定日期内无可定时时间"),
    err1099("-1099","未知错误");
    private String code;
    private String msg;

    // 构造方法
    private CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 普通方法
    public static String getMsg(String code) {
        for (CodeEnum c : CodeEnum.values()) {
            if (c.getCode().equals(code.trim())) {
                return c.msg;
            }
        }
        return null;
    }

    public static String getCode(String msg) {
        if(StringUtils.hasText(msg)){
            for (CodeEnum c : CodeEnum.values()) {
                if (c.getMsg() .equals(msg.trim())) {
                    return c.code;
                }
            }
        }
        return null;////
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    

}
