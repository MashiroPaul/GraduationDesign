package paul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paul.dao.IUserDAO;
import paul.entity.User;
import paul.service.IUserService;

@Service("userservice")
public class UserService implements IUserService{

	@Autowired
	private IUserDAO userDao;
	
	@Override
	public boolean Login(User user){
		return userDao.Login(user);
	}

}
