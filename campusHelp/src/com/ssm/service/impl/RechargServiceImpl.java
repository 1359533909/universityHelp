package com.ssm.service.impl;

import com.ssm.mapper.RechargeMapper;
import com.ssm.po.Recharge;
import com.ssm.service.RechargService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class RechargServiceImpl  implements RechargService {
    //自动注入没问题，报错的话应该是idea本身的问题
    @Autowired
    RechargeMapper rechargeMapper;

    @Override
    public void insertRecharge(Recharge recharge) {
        Logger logger = LoggerFactory.getLogger(RechargServiceImpl.class);
        rechargeMapper.insertRecharge(recharge);
    }

    @Override
    public void updateAdminRechargeByOrderId(Recharge recharge) {
        rechargeMapper.updateAdminRechargeByOrderId(recharge);
    }
}
