public class Post implements IDisplayable {
    private Stack posts;
    private boolean isPostsVisible;
    
    public Post() {
        posts = new Stack(5);
		isPostsVisible = true;
    }
    
    public void display() {
		if(isPostsVisible) {
            Util.print("Posts: ");
            posts.print();
        }
    }
    
    public void toggleVisibility() {
        isPostsVisible = !isPostsVisible;
    }
	
	public void addPost(String name) {
		posts.push(name);
	}
	
	public String removePost() {
		return posts.pop();
	}
	
	public void removeAllPosts() {
		posts.reset();
	}
	
	public boolean getPostsVisibility() {
		return isPostsVisible;
	}
	public void setPostsVisibility(boolean isPostsVisible) {
		this.isPostsVisible = isPostsVisible;
	}
}