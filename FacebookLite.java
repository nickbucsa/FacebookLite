import java.util.*;
import java.io.*;

public class FacebookLite {
    private Scanner sc;
    private Profile[] profiles;
    private int idx; //index for profiles array
    private int nop; //number of profiles
    private int opt; //option
    
    public FacebookLite() {
        sc = new Scanner(System.in);
        idx = -1;
        nop = 0;
        profiles = new Profile[5];
    }
	public void printMenu() {
		System.out.println("\nWelcome to Facebook Lite!");
		System.out.println("Menu:	");
		System.out.println("\t 0 - exit");
		System.out.println("\t 1 - create profile");
		System.out.println("\t 2 - delete last profile");
		System.out.println("\t 3 - switch profile");
		System.out.println("\t 4 - print profile");
		System.out.println("\t 5 - add friend");
		System.out.println("\t 6 - remove last friend");
		System.out.println("\t 7 - remove all friends");
		System.out.println("\t 8 - add post");
		System.out.println("\t 9 - remove last post");
		System.out.println("\t10 - remove all posts");
		System.out.println("\t11 - toggle age");
		System.out.println("\t12 - toggle friends");
		System.out.println("\t13 - toggle posts");
		System.out.println("\t14 - change status");
		System.out.println("\t15 - delete all profiles");
	}
	public void createProfile(String fname, String lname, int age) {
        if(idx < profiles.length - 1) {
            Profile p = new Profile(fname, lname, age);
            idx++;
            profiles[idx] = p;
            nop++;
            Util.print("Profile created!");
        }
        else {
            Util.print("No room to create a new profile\n");
        }
    }
	public void saveProfiles() {
		try {
			PrintStream writer = new PrintStream(new File("profiles.txt"));
			for(int i = 0; i < nop; i++) {
				writer.print("\r\nPROFILE " + (i+1) + ":\r\n");
				writer.print("//Info//\r\n" + profiles[i].getUser().getFName() + ";;" + profiles[i].getUser().getLName() + ";;" + profiles[i].getUser().getAge() + "\r\n");
				writer.print("//Status//\r\n" + profiles[i].getUser().getStatus() + "\r\n");
				writer.print("//Friends//\r\n");
				String[] friendsToWrite = profiles[i].getFriends();
				for (int j = 0; j < friendsToWrite.length; j++) {
					if (!friendsToWrite[j].equals(""))
						writer.print(friendsToWrite[j] + "\r\n");
				}
				writer.print("//Posts//\r\n");
				String[] postsToWrite = profiles[i].getPosts();
				for (int j = 0; j < postsToWrite.length; j++) {
					if (!postsToWrite[j].equals(""))
						writer.print(postsToWrite[j] + "\r\n");
				}
				boolean booo = profiles[i].getAgeVisibility();
				writer.print("//Show Age//\r\n" + booo + "\r\n");
				booo = profiles[i].getFriendsVisibility();
				writer.print("//Show Friends//\r\n" + booo + "\r\n");
				booo = profiles[i].getPostsVisibility();
				writer.print("//Show Posts//\r\n" + booo + "\r\n");
				//writer.flush();
			}
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Error writing to \"profiles.txt\" ! ");
		}
	}
	public void loadProfiles() {
		String[] arr = null;
		int tempIdx = 0;
		try {
			Scanner sc = new Scanner(new File("profiles.txt"));
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
				lines.add(sc.nextLine());
			}
			arr = lines.toArray(new String[]{});
			sc.close();
		}
		catch(IOException e) {
			System.out.println("Error reading from \"profiles.txt\" ! ");
		}
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals("//Info//")) {
				String[] info = arr[i+1].split(";;");
				String arr1 = info[0];
				String arr2 = info[1];
				int arr3 = Integer.parseInt(info[2]);
				createProfile(arr1, arr2, arr3);
			}
			if (arr[i].equals("//Status//") && !arr[i+1].equals("//Friends//")) {
				changeStatus(arr[i+1]);
			}
			if (arr[i].equals("//Friends//") && !arr[i+1].equals("//Posts//")) {
				int j = i + 1;
				while (!arr[j].equals("//Posts//")) {
					addFriend(arr[j]);
					j++;
				}
			}
			if (arr[i].equals("//Posts//") && !arr[i+1].equals("//Show Age//")) {
				int j = i + 1;
				while (!arr[j].equals("//Show Age//")) {
					addPost(arr[j]);
					j++;
				}
			}
			if (arr[i].equals("//Show Age//")) {
				boolean b = Boolean.parseBoolean(arr[i+1]);
				setAgeVisibility(b);
			}
			if (arr[i].equals("//Show Friends//")) {
				boolean b = Boolean.parseBoolean(arr[i+1]);
				setFriendsVisibility(b);
			}
			if (arr[i].equals("//Show Posts//")) {
				boolean b = Boolean.parseBoolean(arr[i+1]);
				setPostsVisibility(b);
			}
		}
	}
	public void printProfile() {
		profiles[idx].printProfile();
	}
	public void removeLastProfile() {
		profiles[idx] = null;
		idx--;
		nop--;
	}
	public void switchProfile(int index) {
		idx = index;
	}
	public void addFriend(String name) {
		profiles[idx].addFriend(name);
	}
	public String removeFriend() {
		return profiles[idx].removeFriend();
	}
	public void removeAllFriends() {
		profiles[idx].removeAllFriends();
	}
	public void addPost(String name) {
		profiles[idx].addPost(name);
	}
	public String removePost() {
		return profiles[idx].removePost();
	}
	public void removeAllPosts() {
		profiles[idx].removeAllPosts();
	}
	public void toggleAge() {
		profiles[idx].toggleAge();
	}
	public void setAgeVisibility(boolean b) {
		profiles[idx].setAgeVisibility(b);
	}
	public void toggleFriends() {
		profiles[idx].toggleFriends();
	}
	public void setFriendsVisibility(boolean b) {
		profiles[idx].setFriendsVisibility(b);
	}
	public void togglePosts() {
		profiles[idx].togglePosts();
	}
	public void setPostsVisibility(boolean b) {
		profiles[idx].setPostsVisibility(b);
	}
	public void changeStatus(String stat) {
		profiles[idx].setStatus(stat);
	}
	public void removeAllProfiles() {
		while (idx != -1) {
			profiles[idx] = null;
			idx--;
		}
		nop = 0;
	}
	
    public static void main(String[] args) {
        FacebookLite fbl = new FacebookLite();
		File f = new File("profiles.txt");
		if (f.isFile() && f.canRead())
			if (f.length() != 0)
				fbl.loadProfiles();
        while(true) {
			fbl.printMenu();
			Util.print("Enter option: ");
			try {
				fbl.opt = Integer.parseInt(fbl.sc.nextLine());
			}
			catch (NumberFormatException nfe) {
				Util.print("Bad input! Try again! ");
				continue;
			}
            switch(fbl.opt) {
                case 0: //exit
					fbl.saveProfiles();
					Util.print("Saving to \"profiles.txt\"\nHave a nice day!");
					return;
                case 1: //create profile
                    boolean real1 = true, real2 = true, real3 = true;
					int age = 0;
					String fname = null, lname = null;
					// testing the first name
					while (real1) {
						Util.print("Please enter your first name: ");
						fname = fbl.sc.nextLine();
						if (fname.trim().isEmpty())
							Util.print("That is not a valid name! ");
						else
							real1 = false;
					}
					// testing the last name
					while (real2) {
						Util.print("Please enter your last name: ");
						lname = fbl.sc.nextLine();
						if (lname.trim().isEmpty())
							Util.print("That is not a valid name! ");
						else
							real2 = false;
					}
					// testing for the age
					while (real3) {
						Util.print("Please enter your age: ");
						try {
							age = Integer.parseInt(fbl.sc.nextLine());
						}
						catch (NumberFormatException nfe) {
							Util.print("Bad input! Try again! ");
							continue;
						}
						if (age < 10 || age > 100)
							Util.print("That is not a valid age! ");
						else
							real3 = false;
					}
                    fbl.createProfile(fname, lname, age);
                break;
                case 2: //delete last profile
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.removeLastProfile();
						Util.print("Last profile deleted! ");
					}
                break;
                case 3:  //switch profiles
					int newIdx = 0;
					boolean real4 = true;
					if (fbl.nop < 2) {
						Util.print("Create more profiles first! ");
					} else {
						Util.print("Current profiles: ");
						for (int i = 0; i < fbl.nop; i++) {
							Util.print(i +" : ");
							fbl.profiles[i].printProfile();
						}
						while (real4) {
							Util.print("Which profile would you like to switch to? ");
							try {
								newIdx = Integer.parseInt(fbl.sc.nextLine());
							}
							catch (NumberFormatException nfe) {
								Util.print("Bad input! Try again! ");
								continue;
							}
							if (newIdx < 0 || newIdx > fbl.nop - 1)
								Util.print("That is not a valid profile! Must be between 0 and " + (fbl.nop - 1));
							else
								real4 = false;
						}
							
						fbl.switchProfile(newIdx);
						Util.print("Profile switched!");
					}
                break;
                case 4:  //print profile
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						Util.print("Current profile: ");
						fbl.printProfile();
					}
                break;
                case 5:  //add friend
					boolean real5 = true;
					String newFriend = null;
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						while (real5) {
							Util.print("Enter friends name: ");
							newFriend = fbl.sc.nextLine();
							if (newFriend.trim().isEmpty())
								Util.print("That is not a valid name! ");
							else
								real5 = false;
						}
						fbl.addFriend(newFriend);
						Util.print("Friend added! ");
					}
                break;
                case 6:  //remove last friend
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						if (fbl.removeFriend().isEmpty())
							Util.print("There are no friends to remove! ");
						else
							Util.print("Friend removed! ");
					}
                break;
                case 7:  //remove all friends
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.removeAllFriends();
						Util.print("All friends removed! ");
					}
                break;
                case 8:  //add post
					boolean real6 = true;
					String newPost = null;
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						while (real6) {
							Util.print("Enter a post: ");
							newPost = fbl.sc.nextLine();
							if (newPost.trim().isEmpty())
								Util.print("That is not a valid post! ");
							else
								real6 = false;
						}
						fbl.addPost(newPost);
						Util.print("Posted! ");
					}
                break;
                case 9:  //remove last post
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						if (fbl.removePost().isEmpty())
							Util.print("There are no posts to remove! ");
						else
							Util.print("Post removed! ");
					}
                break;
                case 10: //remove all posts
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.removeAllPosts();
						Util.print("All posts removed! ");
					}
                break;
                case 11: //toggle age
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.toggleAge();
						Util.print("Age visibility toggled! ");
					}
                break;
                case 12: //toggle friends
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.toggleFriends();
						Util.print("Friends visibility toggled! ");
					}
                break;
                case 13: //toggle posts
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						fbl.togglePosts();
						Util.print("Posts visibility toggled! ");
					}
                break;
                case 14: //change status
					boolean real7 = true;
					String newStat = null;
					if (fbl.nop == 0) {
						Util.print("Create profile first! ");
					} else {
						while (real7) {
							Util.print("Enter new status: ");
							newStat = fbl.sc.nextLine();
							if (newStat.trim().isEmpty())
								Util.print("That is not a valid post! ");
							else
								real7 = false;
						}
						fbl.changeStatus(newStat);
						Util.print("New status created! ");
					}
                break;
                case 15: //delete all profiles
					if (fbl.nop == 0) {
						Util.print("Nothing to delete! Create profile first! ");
					} else {
						fbl.removeAllProfiles();
						Util.print("All profiles deleted! ");
					}
                break;
				default:
					Util.print("Please enter an option that exists in the menu(0 to 15)! ");
				break;
            }
        }
    }
}