package com.ssm.service;

import com.ssm.po.Recharge;
import com.ssm.po.Withdraw;

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
public interface WithdrawService {
    /*
    申请提现
     */
    public void insertWithdraw(Withdraw withdraw);

    /**
     * 通过studentid获取所有申请数额
     */
    public List<Integer> getAmountByStudentid(String studentid);

    /**
     * 获取所有体现订单信息
     * @return
     */
    public List<Withdraw> selectAllWithdraw();

    /**
     * 写入操作管理员信息
     * @param withdraw
     */
    public void updateAdminWithdrawByOrderId(Withdraw withdraw);

    void updateMinusMoney(Withdraw withdraw);
}
