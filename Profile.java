import java.util.ArrayList;
/* @author Harish Rajmohan
* @author Junwei Hu 
* @author Eren Saglam
* @author Herman Kambow
*/
public class Profile {
	private String name;
	private String status;
	// private ArrayList<String> friends;

	public Profile() {
		this.name = "Guest";
		this.status = "Online";
		//this.friends = new ArrayList<>();
	}

	public Profile(String name) {
		this.name = name;
		this.status = "Online";
		//this.friends = new ArrayList<>();
	}

	public String getStatus() {
		return status;
	}

	public void setOnlineStatus() {
		this.status = "Online";
	}

	public void setOfflineStatus() {
		this.status = "Offline";
	}

	public void setBusyStatus() {
		this.status = "Busy";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




// ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶
// 	public ArrayList<String> getFriends() {
// 		return friends;
// 	}

// 	public int getIndexOfFriend(String fName) {
// 		int index = -1;
// 		for (int i = 0; i < friends.size(); i++) {
// 			if (friends.get(i).equalsIgnoreCase(fName)) {
// 				index = i;
// 				break;
// 			}
// 		}
// 		return index;
// 	}

// 	public void addFriend(String fName) {
// 		int index = getIndexOfFriend(fName);
// 		if (index == -1) {
// // good to add
// 			friends.add(fName);
// 			System.out.println(fName + " added as a friend.\n");
// 		} else
// 			System.out.println(fName + " is already added as a friend!\n");
// 	}

// 	@Override
// 	public String toString() {
// 		String out = "Profile Name: " + getName() + ", Status: " + getStatus();
// 		if (friends.isEmpty())
// 			return out;
// 		else {
// 			out += "\nFriends: ";
// 			for (int i = 0; i < friends.size(); i++) {
// 				if (i == friends.size() - 1)
// 					out += friends.get(i);
// 				else
// 					out += friends.get(i) + ", ";
// 			}
// 			return out;
// 		}
// 	}
}