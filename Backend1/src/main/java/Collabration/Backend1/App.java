package Collabration.Backend1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Dao.BlogPostDao;
import Dao.FriendsDao;
import Dao.JobDao;
import Dao.ProfilePictureDao;
import Dao.UserDao;
public class App
{
	private static ApplicationContext ctx;

	public static void main( String[] args )
    {
try {
	ctx = new AnnotationConfigApplicationContext(DBConfig.class);
    UserDao s=(UserDao)ctx.getBean("UserDao");
    User s1=new User();
    s1.setEmail("hhh");
   s.registerUser(s1);
    
    
    BlogPostDao e=(BlogPostDao)ctx.getBean("BlogpostDao");
    Blogpost e1=new Blogpost();
    BlogComment b=new BlogComment();
    e1.setBlogTitle("chat");
    e1.setDescription("social network");
    e1.setApproved(true);
    e1.setId(1);
    e1.setPostedBy(s1);
    b.setBlogpost(e1);
    b.setCommentedBy(s1);
    b.setCommentText("Type comment");
    e.addBlogcomment(b);
    
    FriendsDao f=(FriendsDao)ctx.getBean("friendsDao");
    Friend f1=new Friend();
    f1.setFromId("z");
    f1.setId(1);
    f1.setToId("k");
    f.addFriendRequest("keerthi","1");
    
    JobDao j=(JobDao)ctx.getBean("JobDao");
    job j1=new job();
    j1.setJob(1);
    j1.setCompanyname("niit");
    j1.setJobTitle("group chat");
    j1.setSalary("500000");
    j.saveJob(j1);
    
    ProfilePictureDao p=(ProfilePictureDao)ctx.getBean("ProfilePictureDao");
    ProfilePicture p1=new ProfilePicture();
    p1.setUsername("ramya");
    p.saveProfilePicture(p1);
    System.out.println("table created");
    }

catch (Throwable e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}