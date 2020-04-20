package com.ssm.configuration;

import com.ssm.properties.IdWorker;
import com.ssm.properties.IdWorkerProperties;
import com.ssm.sms.SmsSendVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * #
 * # 　　　┏┓　　　┏┓
 * # 　　┏┛┻━━━┛┻┓
 * # 　　┃　　　　　　　 ┃
 * # 　　┃　　　━　　　 ┃
 * # 　　┃　┳┛　┗┳　┃
 * # 　　┃　　　　　　　 ┃
 * # 　　┃　　　┻　　　 ┃
 * # 　　┃　　　　　　　 ┃
 * # 　　┗━┓　　　┏━┛Codes are far away from bugs with the animal protecting
 * # 　　　　┃　　　┃    神兽保佑,代码无bug
 * # 　　　　┃　　　┃
 * # 　　　　┃　　　┗━━━┓
 * # 　　　　┃　　　　　 ┣┓
 * # 　　　　┃　　　　 ┏┛
 * # 　　　　┗┓┓┏━┳┓┏┛
 * # 　　　　　┃┫┫　┃┫┫
 * # 　　　　　┗┻┛　┗┻┛
 */
@Configuration
public class IdWorkerConfig {
    @Autowired
    IdWorkerProperties prop;
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(prop.getWorkerId(), prop.getDataCenterId());
    }

    @Bean
    public SmsSendVerification sendVerification(){
        return new SmsSendVerification();
    }

}
