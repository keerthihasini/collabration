package Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Collabration.Backend1.BlogComment;
import Collabration.Backend1.Blogpost;

@Repository
@Transactional

public class BlogPostDaoimpl implements BlogPostDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void saveBlogPost(Blogpost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(blogPost);
		
	}

	public List<Blogpost> getBlogPosts(int approved) {
		Session session=sessionFactory.getCurrentSession();
		//if approved method parameter is 0 => select * from blogpost where approved = 0;[ waiting for approval]
		//if approved method parameter is 1 => select * from blogpost where approved = 1;[ approved blogpost]
		Query query=session.createQuery("from BlogPost where approved="+approved);
		//session.flush();
		return query.list();
	}

	public Blogpost getBlogPostById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Blogpost blogpost=(Blogpost)session.get(Blogpost.class, id);
		//session.flush();
		return blogpost;
	}

	public void updateBlogPost(Blogpost blogPost) {
		Session session=sessionFactory.getCurrentSession();
		System.out.println(blogPost.isApproved()+" approved ");
		session.saveOrUpdate(blogPost);//update blogpost set approved=1 wehere id=248
        //session.flush();
 
		System.out.println(blogPost.isApproved());
		
	}

	public void addBlogcomment(BlogComment blogComment) {
		if(blogComment==null)
		{
			System.out.println("null found");
		}
		
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("executing");
		try {

	           System.out.println(blogComment.getBlogpost());
	           System.out.println(blogComment.getCommentedOn());
			session.save(blogComment);
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		System.out.println("inserted");
		//session.flush();
		  
		
		//session.close();
		
	}

	public List<BlogComment> getAllBlogComments(int blogPostId) {
		Session session=sessionFactory.getCurrentSession();
		//select * from blogcomment where blogpost_id=246
		Query query=session.createQuery("from BlogComment where blogPost.id=?");
		query.setInteger(0,  blogPostId);
		//session.flush();
		return query.list();
	}
}