package com.ssm.mapper;

import com.ssm.po.MyEvaluation;
import com.ssm.po.Task;

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
public interface EvaluationMapper {
    public void insertEvaluation(MyEvaluation evaluation);

    /**
     * 任务表和评价表两表查询
     * @return
     */
    List<MyEvaluation> getEvaluationByTaskidAndUserId(int userId);

    void updateStateByTaskId(String taskId);

    void updateEvaluationBytaskid(MyEvaluation evaluation);

    MyEvaluation getEvaluationByTaskid(int taskid);
}
