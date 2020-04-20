package com.ssm.service;

import java.util.List;

import com.ssm.po.Recharge;
import org.apache.ibatis.annotations.Param;

import com.ssm.po.User;

public interface UserService {
	
	/**
	 * 用户注册
	 * @return
	 */
	public int setUser(User record);
	
	/**
	 * 账号个数
	 * @param account
	 * @return
	 */
	public int getAccountCount(String account);
	
	/**
	 * 登录
	 * @param account
	 * @return
	 */
	public User login(String account);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUserInfo(User user);
	
	/**
     * 根据账号或昵称查找返回user
     * @param words
     * @return
     */
    public List<User> getByLikeNameAccount(@Param("words")String words);
    
    /**
     * 根据uid查找返回user
     * @param uid
     * @return
     */
    public User getByUid(Integer uid);

	/**
	 * 修改用户余额
	 */
	public void updateAddMoney(Recharge Recharge);

	User getByStudentid(String studentid);

    void updateHierarchyByStudentId(User user);
}
