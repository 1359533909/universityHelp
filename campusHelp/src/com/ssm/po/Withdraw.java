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
public class Withdraw {
    public int id;
    public long orderId;
    public String studentid;
    public int  schoolid;  //学院id
    public String  school; //学院名
    public String name;
    public  int amount;
    public int isWithdraw;
    public String adminAcount;
    public String adminName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIsWithdraw() {
        return isWithdraw;
    }

    public void setIsWithdraw(int isWithdraw) {
        this.isWithdraw = isWithdraw;
    }

    public String getAdminAcount() {
        return adminAcount;
    }

    public void setAdminAcount(String adminAcount) {
        this.adminAcount = adminAcount;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", studentid='" + studentid + '\'' +
                ", schoolid=" + schoolid +
                ", school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", isWithdraw=" + isWithdraw +
                ", adminAcount='" + adminAcount + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
