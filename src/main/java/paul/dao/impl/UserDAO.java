package paul.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import paul.dao.IUserDAO;
import paul.entity.User;

@Repository
public class UserDAO implements IUserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean Login(User user){
		boolean result = false;
		String hql = "from user where user_username=?0 and user_password=?1";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("0", user.getUser_username());
		query.setParameter("1", user.getUser_password());
//		System.out.println(query.list().size());
		if(query.list().size()!=0){
			result = true;
		}else{
			result=false;
		}
		
		return result;
	}
}
