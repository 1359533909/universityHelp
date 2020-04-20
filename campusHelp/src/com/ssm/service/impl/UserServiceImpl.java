package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ssm.po.Recharge;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.po.User;
import com.ssm.service.UserService;

/**
 * @Service  默认bean名称userServiceImpl
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	@Override
	public int setUser(User record) {
		int result = 0;
		try {
			result = userMapper.insert(record);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public int getAccountCount(String account) {
		int result = 0;
		result = userMapper.selectAccountCount(account);
		return result;
	}

	@Override
	public User login(String account) {
		User user = null;
		user = userMapper.selectUserByAccount(account);
		return user;
	}

	@Override
	public int updateUserInfo(User user) {
		int result = 0;
		try {
			result = userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public List<User> getByLikeNameAccount(String words) {
		List<User> list = null;
		list = userMapper.selectByLikeNameAccount(words);
		return list;
	}

	@Override
	public User getByUid(Integer uid) {
		User user = null;
		user = userMapper.selectByPrimaryKey(uid);
		return user;
	}

	@Override
	public void updateAddMoney(Recharge Recharge) {
		userMapper.updateAddMoney(Recharge);
	}

	@Override
	public User getByStudentid(String studentid) {
		User user=userMapper.selectByStudentid(studentid);
		return user;
	}

	@Override
	public void updateHierarchyByStudentId(User user) {
		userMapper.updateHierarchyByStudentId(user);
	}

}
