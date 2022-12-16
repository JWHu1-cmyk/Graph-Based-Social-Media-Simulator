import java.util.Scanner;
/* @author Harish Rajmohan
* @author Junwei Hu 
* @author Eren Saglam
* @author Herman Kambow
*/

public class Driver {

	public static void main(String[] args) {

	ProfileOperations profileOps = new ProfileOperations();

		profileOps.createProfile();
		profileOps.createProfile();
		profileOps.addFriends();
 		profileOps.showListOfFriends();




	// previous driver
		// Scanner sc = new Scanner(System.in);
		// ProfileOperations profileOps = new ProfileOperations();
		// int choice;

		// do {
		// 	displayMenu();
		// 	choice = Integer.parseInt(sc.nextLine().trim());
		// 	switch (choice) {
		// 		case 1: {
		// 			System.out.println("\nCREATE PROFILE MODULE:\n" + "----------------------");
		// 			profileOps.createProfile();
		// 			break;
		// 		}

		// 		case 2: {
		// 			System.out.println("\nSEARCH PROFILE MODULE:\n" + "----------------------");
		// 			profileOps.searchProfile();
		// 			break;
		// 		}

		// 		case 3: {
		// 			System.out.println("\nADD FRIENDS MODULE:\n" + "-------------------");
		// 			profileOps.addFriends();
		// 			break;
		// 		}

		// 		case 4: {
		// 			System.out.println("\nREMOVE FRIENDS MODULE:\n" + "----------------------");
		// 			profileOps.deleteFriends();
		// 			break;
		// 		}

		// 		case 5: {
		// 			System.out.println("\nUPDATE PROFILE MODULE:\n" + "----------------------");
		// 			profileOps.updateProfile();
		// 			break;
		// 		}

		// 		case 6: {
		// 			System.out.println("\nDELETE PROFILE MODULE:\n" + "----------------------");
		// 			profileOps.deleteProfile();
		// 			break;
		// 		}

		// 		case 7: {
		// 			System.out.println("\nREAD PROFILE MODULE:\n" + "----------------------");
		// 			profileOps.readProfile();
		// 			break;
		// 		}

		// 		case 0: {
		// 			System.out.println(
		// 					"\nThanks for using out Social Networking App.\n" + "Hope to see you soon..Goodbye!\n");
		// 			System.exit(0);
		// 		}
		// 		default:
		// 			System.out.println("\nInvalid selection!\n");
		// 	}
		// } while (choice != 0);



	}

	private static void displayMenu() {
		System.out.print(
				"Choose from the options:\n"
						+ "1. Create profile\n"
						+ "2. Search for a profile\n"
						+ "3. Add friends\n"
						+ "4. Remove friends\n"
						+ "5. Update a profile\n"
						+ "6. Delete a profile\n"
						+ "7. read a profile\n"
						+ "0. Log out\n"
						+ "Your selection >> ");
	}
}