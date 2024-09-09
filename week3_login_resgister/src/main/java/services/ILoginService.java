package services;

import models.Users;

public interface ILoginService {
	// dinh nghia cac phuong thuc 
	void register(Users user);
	boolean login (String usename,String password);
}
