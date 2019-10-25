package Dao;

import java.util.List;

import Collabration.Backend1.job;

public interface JobDao {
	void saveJob(job job);

	List<job> getAllJobs();

	job getJobById(int job);

}
