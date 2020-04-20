package com.ssm.controller;

import com.ssm.po.Admin;
import com.ssm.po.User;
import com.ssm.po.Withdraw;
import com.ssm.properties.CommonProperties;
import com.ssm.properties.IdWorker;
import com.ssm.service.UserService;
import com.ssm.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
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
@Controller
@SessionAttributes({ "nowuser","nowadmin"})
@RequestMapping(value = "withdraw/")
public class WithdrawController {
    @Autowired
    WithdrawService withdrawService;

    @Autowired
    IdWorker idWorker;

    @Autowired
    UserService userService;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @RequestMapping("setWithdraw.do")
    public String setWithdraw(int amount, Model model, HttpServletRequest request){
        if (amount==0){
            model.addAttribute("msg", "申请提现不能为0，申请失败！");
            return "userWithdraw";
        }

        /**
         * 判断用户余额是否足够
         */
        User nowuser = (User) request.getSession().getAttribute("nowuser");
        Withdraw withdraw = new Withdraw();
        withdraw.setAmount(amount);
        withdraw.setName(nowuser.getName());
        withdraw.setIsWithdraw(CommonProperties.notRecharge.getAmount());
        withdraw.setOrderId(idWorker.nextId());
        withdraw.setSchoolid(nowuser.getSchoolid());
        withdraw.setStudentid(nowuser.getStudentid());

        /**
         * 判断已经申请的数额加上余额是否足够
         */
        List<Integer> amountList = withdrawService.getAmountByStudentid(nowuser.getStudentid());
        int allAmount=0;
        for (int number:amountList
             ) {
            allAmount=allAmount+number;
        }
        if (nowuser.getMoney()>=amount) {

            if ((nowuser.getMoney()-allAmount)<amount){

                model.addAttribute("msg", "可申请余额不足，申请失败！");
                return "userWithdraw";
            }else {
                    withdrawService.insertWithdraw(withdraw);
                    model.addAttribute("msg", "申请成功！");
                    return "userWithdraw";
            }

        }
        model.addAttribute("msg", "余额不足，申请失败！");
        return "userWithdraw";
    }

    /**
     * 管理员查看所有提现订单信息
     * @return
     */
    @RequestMapping("getWithdraw.do")
    public String getWithdraw(Model model){
        List<Withdraw> list = withdrawService.selectAllWithdraw();
        model.addAttribute("list",list);
        return "adminWithdraw";
    }

    /**
     * 管理员同意提现
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @RequestMapping("agreeWithdraw.do")
    public String getAgreeWithdraw(long orderId,String name,String studentid,int amount,int schoolid,String school, HttpServletRequest request,Model model){

        Withdraw withdraw=new Withdraw();
        withdraw.setSchool(school);
        withdraw.setSchoolid(schoolid);
        withdraw.setOrderId(orderId);
        withdraw.setName(name);
        withdraw.setAmount(amount);
        withdraw.setStudentid(studentid);


        /**
         * 判断用户余额是否足够提现
         */
        User user= userService.getByStudentid(studentid);
        if (user.getMoney()<amount){
            model.addAttribute("msg","余额不足，提现失败！");
            return "adminWithdraw";
        }

        //		插入withdraw表管理员操作信息
        withdraw.setIsWithdraw(CommonProperties.alreadyRecharge.getAmount());
        Admin oldadmin = (Admin) request.getSession(false).getAttribute("nowadmin");
        withdraw.setAdminName(oldadmin.getName());
        withdraw.setAdminAcount(oldadmin.getAccount());
        withdrawService.updateAdminWithdrawByOrderId(withdraw);

        //用户余额进行减操作
        withdrawService.updateMinusMoney(withdraw);


        List<Withdraw> list = withdrawService.selectAllWithdraw();
        model.addAttribute("list",list);
        return "adminWithdraw";
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @RequestMapping("refuseWithdraw.do")
    public String refuseRecharge(long orderId,String name,String studentid,int amount,int schoolid,String school, HttpServletRequest request,Model model){
        Withdraw withdraw=new Withdraw();
        withdraw.setSchool(school);
        withdraw.setSchoolid(schoolid);
        withdraw.setOrderId(orderId);
        withdraw.setName(name);
        withdraw.setAmount(amount);
        withdraw.setStudentid(studentid);
        System.out.println("同意充值的订单信息："+withdraw.toString());


//		插入recharge表管理员操作信息
        withdraw.setIsWithdraw(CommonProperties.refuseRecharge.getAmount());
        Admin oldadmin = (Admin) request.getSession(false).getAttribute("nowadmin");
        withdraw.setAdminName(oldadmin.getName());
        withdraw.setAdminAcount(oldadmin.getAccount());
        withdrawService.updateAdminWithdrawByOrderId(withdraw);




        List<Withdraw> list = withdrawService.selectAllWithdraw();
        model.addAttribute("msg","拒绝申请提现！");
        model.addAttribute("list",list);
        return "adminWithdraw";
    }
}
