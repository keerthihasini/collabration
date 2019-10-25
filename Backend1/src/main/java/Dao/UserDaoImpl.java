package Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import Collabration.Backend1.User;

public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void registerUser(User user) {

		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		// TODO Auto-generated method stub
		
	}

	
	public User validateUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		//session.flush();
		//session.close();
		return user;
	}


	public User validateEmail(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=?");
		query.setString(0,email);
		User user=(User)query.uniqueResult();
		//session.flush();
		//session.close();
		return user;
	}

	
	public User login(User user) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where username = ? and password = ?");
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		//session.flush();
		//session.close();
		return (User)query.uniqueResult();
	}

	
	public void update(User users) {
		Session session=sessionFactory.getCurrentSession();
		session.update(users);//update the values [online status]
		//session.flush();
		//session.close();
		
	}

	
	public User getUserByUsername(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		//session.flush();
		//session.close();
		return user;
	}

}
