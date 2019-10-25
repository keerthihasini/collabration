package Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Collabration.Backend1.job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveJob(job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		// TODO Auto-generated method stub
		
	}

	
	public List<job> getAllJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Job");
				
		return query.list();
	}

	
	public job getJobById(int job) {
		Session session=sessionFactory.getCurrentSession();
    	job job1=(job)session.get(job.class, job);
    	
		return job1;
	}

}
