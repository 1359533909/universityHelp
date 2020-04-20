package com.ssm.po;

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

/**
 *
 `taskid` int(8) unsigned NOT NULL COMMENT '与任务表一致',
 `content` text COMMENT '评价内容',
 `isEvaluation` tinyint(1) DEFAULT NULL COMMENT '是否评价，1代表TRUE,0代表FALSE',
 `state` int(11) DEFAULT NULL COMMENT '任务状态，3已完成，2解决中，1已关闭，0为完成'
 */

public class MyEvaluation {
    public int taskid;
    public String content;
    public int isEvaluation;
    public int state;
    public int hierarchy;
    public Task task;

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public String toString() {
        return "MyEvaluation{" +
                "taskid=" + taskid +
                ", content='" + content + '\'' +
                ", isEvaluation=" + isEvaluation +
                ", state=" + state +
                ", hierarchy=" + hierarchy +
                ", task=" + task +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsEvaluation() {
        return isEvaluation;
    }

    public void setIsEvaluation(int isEvaluation) {
        this.isEvaluation = isEvaluation;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
