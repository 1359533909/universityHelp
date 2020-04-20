package com.ssm.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ssm.properties.Contant;
import com.ssm.sms.SmsSendVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
@RestController
public class MyRestController {
    @Autowired
    SmsSendVerification sendVerification;
    @Autowired
    StringRedisTemplate redisTemplate;

    public static String generateCode(int len){
        len = Math.min(len, 4);
        int min = Double.valueOf(Math.pow(10, len - 1)).intValue();
        int num = new Random().nextInt(
                Double.valueOf(Math.pow(10, len + 1)).intValue() - 1) + min;
        return String.valueOf(num).substring(0,len);
    }

    @RequestMapping(value = "getPhoneVerificationCode.do",produces = "text/plain;charset=utf-8")
    public String getPhoneVerificationCode(String phoneNumber) throws ClientException {
//        验证手机号码
        String str = phoneNumber;
        if (str.matches(Contant.REGEX_MOBILE)) {
//            生成随机code
            String code = generateCode(4);
            //发短信
        SendSmsResponse response = sendVerification.sendSms(phoneNumber,code);
            if (response.getCode().equals("OK")){
                //将手机验证码存放到缓存中
                redisTemplate.opsForValue().set(phoneNumber,code,5, TimeUnit.MINUTES);
                System.out.println("短信接口返回的数据----------------");
                System.out.println("Code=" + response.getCode());
                System.out.println("Message=" + response.getMessage());
                System.out.println("RequestId=" + response.getRequestId());
                System.out.println("BizId=" + response.getBizId());
                return "验证码发送成功！";
            }else {
                return "验证码获取失败，请稍后重试！";
            }

        } else {
            return "手机号码格式不对！";
        }

    }

}
