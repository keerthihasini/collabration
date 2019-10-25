package Dao;

import Collabration.Backend1.User;

public interface UserDao {

	void registerUser(User user);
	User validateUsername(String username);
	User validateEmail(String email);
	User login(User user);
	void update(User user);
	User getUserByUsername(String username);

}
