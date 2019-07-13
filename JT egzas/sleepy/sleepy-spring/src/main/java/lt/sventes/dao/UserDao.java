package lt.sventes.dao;

import java.util.List;

import lt.sventes.model.User;

public interface UserDao {
	List<User> getUsers();

	void createUser(User user);

	void deleteUser(String username);
}
