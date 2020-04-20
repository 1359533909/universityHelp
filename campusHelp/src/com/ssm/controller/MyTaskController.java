package com.ssm.controller;

import com.ssm.po.MyEvaluation;
import com.ssm.po.User;
import com.ssm.properties.CommonProperties;
import com.ssm.service.EvaluationService;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@SessionAttributes({ "nowuser"})
@RequestMapping(value = "myTask/")
public class MyTaskController {
    @Autowired
    EvaluationService evaluationService;

    @Autowired
    UserService userService;

    @RequestMapping("getAlreadyTask.do")
    public String getAlreadyTask(HttpServletRequest request, Model  model){
        User nowuser = (User) request.getSession(false).getAttribute("nowuser");
        List<MyEvaluation> list = evaluationService.getEvaluationByTaskidAndUserId(nowuser.getStuid());
        model.addAttribute("list",list);

        return "userEvaluationTask";
    }

    @RequestMapping("getNotEvaluateTaskInfo.do")
    public String getNotEvaluateTaskInfo(int taskid,Model model){
        model.addAttribute("taskid",taskid);
        return "evaluateTaskInfo";
    }

    @RequestMapping("updateEvaluation.do")
    public String updateEvaluation(MyEvaluation evaluation,Model model,HttpServletRequest request                                                                                                                                                        ){
        evaluation.setIsEvaluation(CommonProperties.alreadyEvaluation.getAmount());
        User nowuser = (User) request.getSession(false).getAttribute("nowuser");
        nowuser.setHierarchy(evaluation.getHierarchy());
        userService.updateHierarchyByStudentId(nowuser);
        evaluationService.updateEvaluationBytaskid(evaluation);
        model.addAttribute("msg","评价成功！");
        return getNotEvaluateTaskInfo(evaluation.getTaskid(),model);
    }
}
