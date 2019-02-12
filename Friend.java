public class Friend implements IDisplayable {
    private Stack friends;
    private boolean isFriendsVisible;
    
    public Friend() {
        friends = new Stack(5);
        isFriendsVisible = true;
    }
    public void display() {
        if(isFriendsVisible) {
            Util.print("Friends: ");
            friends.print();
        }
    }
    public void toggleVisibility() {
        isFriendsVisible = !isFriendsVisible;
    }
    public void addFriend(String name) {
        friends.push(name);
    }
    public String removeFriend() {
        return friends.pop();
    }
	public void removeAllFriends() {
        friends.reset();
    }
	public boolean getFriendsVisibility() {
		return isFriendsVisible;
	}
	public void setFriendsVisibility(boolean isFriendsVisible) {
		this.isFriendsVisible = isFriendsVisible;
	}
}