package paul.service;

import org.springframework.transaction.annotation.Transactional;

import paul.entity.User;

@Transactional
public interface IUserService {

	public boolean Login(User user);
}
