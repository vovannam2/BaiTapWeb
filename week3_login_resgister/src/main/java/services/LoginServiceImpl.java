package services;

import Dao.ILoginDao;
import Dao.LoginImplDao;
import models.Users;

public class LoginServiceImpl implements ILoginService{

	ILoginDao userDao = new LoginImplDao();
	@Override
	public void register(Users user) {
		
		userDao.resgister(user);
	}
	@Override
	public boolean login(String usename, String password) {
		return userDao.login(usename, password);
		
	}

}
