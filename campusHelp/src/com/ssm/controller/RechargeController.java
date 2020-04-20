package com.ssm.controller;

import com.ssm.po.Admin;
import com.ssm.po.Recharge;
import com.ssm.po.School;
import com.ssm.po.User;
import com.ssm.properties.CommonProperties;
import com.ssm.properties.IdWorker;
import com.ssm.service.RechargService;
import com.ssm.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(value = "recharge/")
public class RechargeController {

    @Autowired
    IdWorker idWorker;

    @Autowired
    SchoolService schoolService;

    @Autowired
    RechargService rechargService;
    //申请充值
    @RequestMapping("setCharge.do")
    @Transactional
    public String recharge(int amount,HttpServletRequest request, Model model) {

        User nowuser = (User) request.getSession(false).getAttribute("nowuser");

        Recharge recharge = new Recharge();
        recharge.setAmount(amount);
        recharge.setName(nowuser.getName());
        recharge.setIsRecharge(CommonProperties.notRecharge.getAmount());
        recharge.setOrderId(idWorker.nextId());
        recharge.setSchoolid(nowuser.getSchoolid());
        recharge.setStudentid(nowuser.getStudentid());


        System.out.println(recharge.toString());
        rechargService.insertRecharge(recharge);
        model.addAttribute("msg","申请成功！");
        return "userRecharge";
    }


}
