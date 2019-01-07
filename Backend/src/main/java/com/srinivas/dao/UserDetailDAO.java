package com.srinivas.dao;

import java.util.List;

import com.srinivas.model.UserDetail;

public interface UserDetailDAO {
	
	public boolean addUserDetail(UserDetail user);
	public boolean deleteUserDetail(UserDetail user);
	public boolean updateUserDetail(UserDetail user);
	public List<UserDetail> listUserDetail();
	public UserDetail getUserDetail(String username);
	
	

}
