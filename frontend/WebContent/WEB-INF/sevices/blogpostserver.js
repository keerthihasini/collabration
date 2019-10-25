/**
 * BlogPostService
 */

app.factory('BlogPostService',function($http){
	var blogPostService={};
	
	blogPostService.addBlogPost=function(blogPost){
		return $http.post("http://localhost:8082/CollaborationBackend/saveblogpost",blogPost)
	}
	
	blogPostService.getBlogPostsWaitingForApproval=function(){
		return $http.get("http://localhost:8082/CollaborationBackend/getblogposts/"+0)
	}
	
	blogPostService.getBlogPostsApproved=function(){
		return $http.get("http://localhost:8082/CollaborationBackend/getblogposts/"+1)
	}
	
	blogPostService.getBlogPostById=function(id){
		return $http.get("http://localhost:8082/CollaborationBackend/getblogpostbyid/"+id)
	}
	
	blogPostService.updateBlogPost=function(blogPost){
		return $http.put("http://localhost:8082/CollaborationBackend/updateblogpost",blogPost)
	}
	blogPostService.addComment=function(blogComment){
		return $http.post("http://localhost:8082/CollaborationBackend/addblogcomment",blogComment)
	}
	blogPostService.getBlogComments=function(blogPostId){
		return $http.get("http://localhost:8082/CollaborationBackend/getblogcomments/"+blogPostId)
	}
	return blogPostService;
})

