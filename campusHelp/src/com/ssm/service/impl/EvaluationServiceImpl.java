package com.ssm.service.impl;

import com.ssm.mapper.EvaluationMapper;
import com.ssm.po.MyEvaluation;
import com.ssm.service.EvaluationService;
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
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public void insertEvaluation(MyEvaluation evaluation) {
        evaluationMapper.insertEvaluation(evaluation);
    }

    @Override
    public List<MyEvaluation> getEvaluationByTaskidAndUserId(int userId) {
        List<MyEvaluation> myEvaluation = evaluationMapper.getEvaluationByTaskidAndUserId(userId);
        return myEvaluation;
    }

    @Override
    public void updateStateByTaskId(String taskId) {
        evaluationMapper.updateStateByTaskId(taskId);
    }

    @Override
    public void updateEvaluationBytaskid(MyEvaluation evaluation) {
        evaluationMapper.updateEvaluationBytaskid(evaluation);
    }

    @Override
    public MyEvaluation getEvaluationByTaskid(int taskid) {
        MyEvaluation myEvaluation=evaluationMapper.getEvaluationByTaskid(taskid);
        return myEvaluation;
    }
}
