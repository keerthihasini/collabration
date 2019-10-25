package Collabration.Backend1;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Dao.BlogPostDao;
import Dao.BlogPostDaoimpl;
import Dao.FriendsDao;
import Dao.FriendsDaoimpl;
import Dao.JobDao;
import Dao.JobDaoImpl;
import Dao.ProfilePictureDao;
import Dao.ProfilePictureDaoImpl;
import Dao.UserDao;
import Dao.UserDaoImpl;
@Configuration
@EnableTransactionManagement
public class DBConfig {
	@Bean("dataSource")
	public DataSource getH2DataSource()
	{
	DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl(" jdbc:h2:tcp://localhost/~/test");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}
	@Bean(name="sessionFactory")
	 public SessionFactory getSessionFactory()
   {  
   	System.out.println("------Hibernate Properties----");
   	Properties prop = new Properties();
   	prop.setProperty("hibernate.hbm2ddl.auto", "create");
   	prop.put("hibernate.show_sql", "true");
   	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
   	System.out.println("-----Hibernate properties created----");
   	
   	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
   	sessionBuilder.addProperties(prop);
   	sessionBuilder.addAnnotatedClass(Blogpost.class);
   	sessionBuilder.addAnnotatedClass(User.class);
   	SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
	return sessionFactory;
	
}
@Bean("txManager")
public HibernateTransactionManager getTransactionManager()
{
HibernateTransactionManager manager=new HibernateTransactionManager(getSessionFactory());	
return manager;
}
@Bean("BlogpostDao")
BlogPostDao getBlogPostDao()
{
	BlogPostDaoimpl s=new BlogPostDaoimpl();
	 return s;
}
@Bean("UserDao")
UserDao getUserDao()
{
	UserDaoImpl s=new UserDaoImpl();
	 return s;
}
@Bean("friendsDao")
FriendsDao getFriendsDao()
{
	FriendsDaoimpl s=new FriendsDaoimpl();
	 return s;
}

@Bean("JobDao")
JobDao getJobDao()
{
	JobDaoImpl s=new JobDaoImpl();
	 return s;
}
@Bean("ProfilePictureDao")
ProfilePictureDao getProfilePictureDao()
{
	ProfilePictureDaoImpl s=new ProfilePictureDaoImpl();
	 return s;
}
}
