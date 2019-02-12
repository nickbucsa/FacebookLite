public class Profile {
	private User u;
    private Friend f;
    private Post p;
    
    public Profile(String fname, String lname, int age) {
        u = new User(fname, lname, age);
        f = new Friend();
        p = new Post();
    }
    public void printProfile() {
        u.display();
        f.display();
        p.display();
    }
    public User getUser() {
		return u;
	}
	public void setStatus(String status) {
        u.setStatus(status);
    }
	public String[] getFriends() {
		String[] fr = new String[5];
		for (int i = 0; i < 5; i++) {
			fr[i] = f.removeFriend();
		}
		return fr;
	}
	public void addFriend(String name) {
        f.addFriend(name);
    }
    public String removeFriend() {
        return f.removeFriend();
    }
	public void removeAllFriends() {
        f.removeAllFriends();
    }
	public String[] getPosts() {
		String[] ps = new String[5];
		for (int i = 0; i < 5; i++) {
			ps[i] = p.removePost();
		}
		return ps;
	}
	public void addPost(String name) {
		p.addPost(name);
	}
	public String removePost() {
		return p.removePost();
	}
	public void removeAllPosts() {
		p.removeAllPosts();
	}
	public void toggleAge() {
		u.toggleVisibility();
	}
	public boolean getAgeVisibility() {
		return u.getAgeVisibility();
	}
	public void setAgeVisibility(boolean b) {
		u.setAgeVisibility(b);
	}
	public void toggleFriends() {
		f.toggleVisibility();
	}
	public boolean getFriendsVisibility() {
		return f.getFriendsVisibility();
	}
	public void setFriendsVisibility(boolean b) {
		f.setFriendsVisibility(b);
	}
	public void togglePosts() {
		f.toggleVisibility();
	}
	public boolean getPostsVisibility() {
		return p.getPostsVisibility();
	}
	public void setPostsVisibility(boolean b) {
		p.setPostsVisibility(b);
	}
}