//import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/* @author Harish Rajmohan
* @author Junwei Hu 
* @author Eren Saglam
* @author Herman Kambow
*/
public class ProfileOperations {
	private ArrayList<Profile> profiles;

	@Deprecated
	private LinkedDictionary<Profile, ArrayList> friendsList;
	
	private UndirectedGraph<String> friendList1;
// replaces friendsList

	public ProfileOperations() {

		this.profiles = new ArrayList<>();

		this.friendsList = new LinkedDictionary<>();

		this.friendList1 = new UndirectedGraph<>();

	}

	// get the index of the profile within arraylist profiles given profile name
	// good to go
	public int getIndexOfProfile(String name) {
		int index = -1;
		for (int i = 1; i <= profiles.getLength(); i++) {
			if (profiles.getEntry(i).getName().equalsIgnoreCase(name)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void addFriends() {

		// procedure to see whether the profile to have friends added exist within profiles arraylist
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to be having friends added to: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1) {
			System.out.println("There's no such profile named " + pName + "!\n");
			return;
			// nice, never thought about return
		}



		// procedure to add friends to the intended profile, friendsList is a dictionary, you use the profile to find an arraylist that contains its friends, then you add the new friend's name
		System.out.print("Enter the name of the friend: ");
		String fName = sc.nextLine().trim();
		int index1 = getIndexOfProfile(fName);
		if (index1 == -1) {
			System.out.println("There's no such profile named " + fName + "!\n");
			return;
			// nice, never thought about return
		}
		// profiles.get(index).addFriend(fName);
		// friendsList.getValue(profiles.getEntry(index)).add(fName);
			friendList1.addEdge(pName, fName);
		// for (int i = 0; i < friendsList.getValue(profiles.get(index)).size(); i++) {
		// System.out.println("\n"+friendsList.getValue(profiles.get(index)).get(i));
		// }

	}

		// @ testing method fo addFriend()'s graph implementation
	public void showListOfFriends(){
		String Name1;
		System.out.printf("\nenter friend's name to see friend's friendList:");
		Scanner sc = new Scanner(System.in);
			Name1 = sc.next();
 		Iterator<VertexInterface<String>> neighborList1 = friendList1.getVertex(Name1).getNeighborIterator();
		while (neighborList1.hasNext()){
			System.out.printf(neighborList1.next().getLabel());
		}
		System.out.printf("\n");
	}



	public void deleteFriends() {

			// procedure to see whether the profile to have friends added exist within profiles arraylist
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name for deleteing friends: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1) {
			System.out.println("There's no such profile named " + pName + "!\n");
			return;
			// nice, never thought about return
		}



		// procedure to delete friends from the intended profile, friendsList is a dictionary, you use the profile to find an arraylist that contains its friends, then you delete the friend's name
		System.out.print("Enter the name of the friends to be deleted: ");
		String deletedName = sc.nextLine().trim();
		ArrayList friendsListForOnePerson = friendsList.getValue(profiles.getEntry(index));
		int indexForFriendsListForOnePerson = -1;
		for (int i = 1; i <= friendsListForOnePerson.getLength(); i++) {
			if (friendsListForOnePerson.getEntry(i).equals(deletedName)) {

				indexForFriendsListForOnePerson = i;
				break;
			}
		}
		if (indexForFriendsListForOnePerson != -1) {
			friendsListForOnePerson.remove(indexForFriendsListForOnePerson);
		} else {
			System.out.print("\nfriend not found");
		}

	}



 	// good to go
	// made changes for dictionary
	public void createProfile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name: ");
		String pName = sc.nextLine().trim();



			// @ for testing purposes
		// Profile profile = new Profile(pName);
		// profiles.add(profile);
		// friendList1.addVertex(pName);



		// @ for testing purposes, blacked this out;
		// no need to be rewritten, it creates profile for private ArrayList<Profile> profiles;
			int index = getIndexOfProfile(pName);
			if (index == -1) {
				// profile not present, can add it
				Profile profile = new Profile(pName);
				System.out.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
				int stChoice = Integer.parseInt(sc.nextLine().trim());
				while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
					System.out.println("Invalid status choice!\n");
					System.out.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
					stChoice = Integer.parseInt(sc.nextLine().trim());
				}
				if (stChoice == 1) {
					profile.setOnlineStatus();
				} else if (stChoice == 2) {
					profile.setOfflineStatus();
				} else if (stChoice == 3) {
					profile.setBusyStatus();
				} else {
					profile.setOfflineStatus();
				}
				System.out.println("Profile status set to " + profile.getStatus() + ".");

				profiles.add(profile);
				System.out.println("Profile has been created for " + pName + ".\n");



				friendList1.addVertex(pName);
					// replaces arrayList based friendList1

					// added by me to accomand dictionary
					// @deprecated
				// ArrayList friendList1 = new ArrayList<>();
				// friendsList.add(profile, friendList1);


			
					// @deprecated
				// char yesNo;
				// do {
				// System.out.print("Add friend? [y/n]: ");
				// yesNo = sc.nextLine().trim().charAt(0);
				// if (yesNo == 'N' || yesNo == 'n')
				// break;
				// else {
				// System.out.print("Name of the friend: ");
				// String fName = sc.nextLine().trim();
				// profile.addFriend(fName);
				// }
				// } while (yesNo != 'N' || yesNo != 'n');
				// profiles.add(profile);
				// System.out.println("Profile has been created for " + pName + ".\n");
			}
	}

	// good to go
	public void searchProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + pName + "!\n");
		else
			System.out.println("Match found:\n" + profiles.getEntry(index) + "\n");
	}

	public void readProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name for reading profiles: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1) {
			System.out.println("There's no such profile named " + pName + "!\n");
			return;
			// nice, never thought about return
		}
		System.out.print("Reading the profile:\n");
		System.out.print("Status: " + profiles.getEntry(index).getStatus() + "\n");



		// @ depreciated, to be reimplemented with friendList
		// System.out.print("friendList: " + "\n");
		// for (int i = 1; i <= friendsList.getValue(profiles.getEntry(index)).getLength(); i++) {
		// 	System.out.print(friendsList.getValue(profiles.getEntry(index)).getEntry(i) + "\n");
		// }



		// String Name1;
		System.out.printf("\nlist of friends:\n");
		// Scanner sc = new Scanner(System.in);
		// 	Name1 = sc.next();
 		Iterator<VertexInterface<String>> neighborList1 = friendList1.getVertex(pName).getNeighborIterator();
		while (neighborList1.hasNext()){
			System.out.printf(neighborList1.next().getLabel() + "\n");
		}
		System.out.printf("\n");



	}

	// good to go
	// acutally there is a problem ,should I give updated firendlist option?
	public void updateProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + pName + "!\n");
		else {
			// update the profile
			System.out.print("Enter new name for the profile: ");
			String newPName = sc.nextLine().trim();
			profiles.getEntry(index).setName(newPName);
			System.out.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
			int stChoice = Integer.parseInt(sc.nextLine().trim());
			while (stChoice != 1 && stChoice != 2 && stChoice != 3) {
				System.out.println("Invalid status choice!\n");
				System.out
						.print("Enter profile status:\n" + "1. Online\n" + "2. Offline\n" + "3. Busy\n" + "Enter >> ");
				stChoice = Integer.parseInt(sc.nextLine().trim());
			}
			if (stChoice == 1)
				profiles.getEntry(index).setOnlineStatus();
			else if (stChoice == 2)
				profiles.getEntry(index).setOfflineStatus();
			else if (stChoice == 3)
				profiles.getEntry(index).setBusyStatus();
			else
				profiles.getEntry(index).setOfflineStatus();



					// functionality taken out because vertex.java does not provide method for you to delete friends, or deconnect so to speak
			// System.out.print("\nWould you like to delete the old friend list, enter 1 for yes, 0 for no \n");
			// int stChoice1 = Integer.parseInt(sc.nextLine().trim());
			// if (stChoice1 == 1) {
			// 	friendsList.getValue(profiles.getEntry(index)).clear();
			// } else {

			// }



			// char yesNo;
			// do {
			// System.out.print("Add friend? [y/n]: ");
			// yesNo = sc.nextLine().trim().charAt(0);
			// if (yesNo == 'N' || yesNo == 'n')
			// break;
			// else {
			// System.out.print("Name of the friend: ");
			// String fName = sc.nextLine().trim();
			// profiles.get(index).addFriend(fName);
			// System.out.println();
			// }
			// } while (yesNo != 'N' || yesNo != 'n');
			System.out.println("Profile updated successfully.\n");
		}
	}

	// good to go
	// added friendsList.remove(profiles.get(index));
	public void deleteProfile() {
		if (profiles.isEmpty()) {
			System.out.println("No profiles yet!\n");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter profile name to search: ");
		String pName = sc.nextLine().trim();
		int index = getIndexOfProfile(pName);
		if (index == -1)
			System.out.println("Sorry, there's no such profile named " + pName + "!\n");
		else {

			// friendsList.remove(profiles.getEntry(index));
				// no longer compatible with graph based final project, thus functionality taken out

			profiles.remove(index);
 			// a new addition
			System.out.println("Profile for " + pName + " is deleted successfully.\n");
		}
	}

}
