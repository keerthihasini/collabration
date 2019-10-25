package Dao;

import java.util.List;

import Collabration.Backend1.BlogComment;

import Collabration.Backend1.Blogpost;

public interface BlogPostDao {

	void saveBlogPost(Blogpost blogPost);

	List<Blogpost> getBlogPosts(int approved);
	
	Blogpost getBlogPostById(int id);

	void updateBlogPost(Blogpost blogPost);

	void addBlogcomment (BlogComment blogComment);
	
	List<BlogComment> getAllBlogComments(int blogPostId);

}
