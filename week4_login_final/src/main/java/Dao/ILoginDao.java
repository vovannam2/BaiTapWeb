package Dao;

import models.Users;

public interface ILoginDao {
	void resgister (Users user);
	boolean login(String username ,String password);
	boolean resetpassword(Users user);
}
