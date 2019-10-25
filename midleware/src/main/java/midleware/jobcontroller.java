package midleware;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Collabration.Backend1.User;
import Collabration.Backend1.job;
import Dao.JobDao;
import Dao.UserDao;

@RestController
public class jobcontroller {
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/savejob",method=RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody job job, HttpSession session)
	{
		System.out.println(session.getAttribute("username"));
		if(session.getAttribute("username")==null)
		{
			Error error = new Error(5,"Unauthorised User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username = (String)session.getAttribute("username");
		User user = userDao.getUserByUsername(username);
		if(user.getRole().equals("ADMIN"))
		{
			try{
				//job.setPostedOn(new Date());
			jobDao.saveJob(job);
			return new ResponseEntity<job>(job, HttpStatus.OK);
			}catch(Exception e){
				Error error = new Error (7, "Unable to insert job details" + e.getMessage());
				return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else
		{
			Error error = new Error(6,"Access Denied");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value="/getallJobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			Error error = new Error(5,"Unauthorised User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<job> jobs=jobDao.getAllJobs();
		return new ResponseEntity<List<job>>(jobs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getjobbyid/{job}",method=RequestMethod.GET)
	public ResponseEntity<?> getJobById(@PathVariable int job,HttpSession session)
	{
		if(session.getAttribute("username")==null)
		{
			Error error = new Error(5,"Unauthorised User");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		job job1 = jobDao.getJobById(job);
		return new ResponseEntity<job>(job1,HttpStatus.OK);	
	}


}
