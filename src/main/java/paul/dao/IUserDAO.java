package paul.dao;

import org.springframework.transaction.annotation.Transactional;

import paul.entity.User;

@Transactional
public interface IUserDAO {

	public boolean Login(User user);
}
