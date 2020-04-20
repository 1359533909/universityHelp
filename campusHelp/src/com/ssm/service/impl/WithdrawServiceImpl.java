package com.ssm.service.impl;

import com.ssm.mapper.RechargeMapper;
import com.ssm.mapper.UserMapper;
import com.ssm.mapper.WithdrawMapper;
import com.ssm.po.Recharge;
import com.ssm.po.Withdraw;
import com.ssm.service.RechargService;
import com.ssm.service.WithdrawService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
public class WithdrawServiceImpl implements WithdrawService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    WithdrawMapper withdrawMapper;

    @Override
    public void insertWithdraw(Withdraw withdraw) {
        withdrawMapper.insertWithdraw(withdraw);
    }

    @Override
    public List<Integer> getAmountByStudentid(String studentid) {
        return withdrawMapper.selectAmountByStudentid(studentid);
    }

    @Override
    public List<Withdraw> selectAllWithdraw() {
        List<Withdraw> list = withdrawMapper.selectAllWithdraw();
        return list;
    }

    @Override
    public void updateAdminWithdrawByOrderId(Withdraw withdraw) {
        withdrawMapper.updateAdminWithdrawByOrderId(withdraw);
    }

    @Override
    public void updateMinusMoney(Withdraw withdraw) {
        userMapper.updateMinusMoney(withdraw);
    }
}
