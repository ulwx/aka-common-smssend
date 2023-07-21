package com.github.ulwx.aka.sms;

import com.github.ulwx.aka.webmvc.MyPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource(name="classpath*:aka-application-smssend.yml"
        , value = {"classpath*:aka-application-smssend.yml"},
        factory = MyPropertySourceFactory.class)

@Configuration("com.github.ulwx.aka.sms.AkaSmsSendConfiguration")
public class AkaSmsSendConfiguration {

}

