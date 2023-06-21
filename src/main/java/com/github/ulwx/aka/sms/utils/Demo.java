package com.github.ulwx.aka.sms.utils;

public class Demo {
    public static void main(String[] args) {

        Integer result2 = SmsUtil.sendMsg("1","18565574709","客户您好，验证码是4444，请勿泄露他人");
        System.out.println(result2);
    }
}
