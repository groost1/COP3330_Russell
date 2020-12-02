import java.util.Scanner;

public class App {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new App();
	}

	public App() {
		menu();
	}

	public void menu() {
		loop: while (true) {
			System.out.println("Select your Application\n----------------------\n");
			System.out.println("1. task list");
			System.out.println("2. contact list");
			System.out.println("3. quit");

			int input = getIntRange(1, 3);
			switch (input) {
			case 1:
				new TaskApp(sc);
				break;
			case 2:
				new ContactApp(sc);
				break;
			case 3:
				break loop;
			}
		}
	}

	// copied from TaskApp
	public int getIntRange(int bottom, int top) {
		while (true) {
			try {
				int input = sc.nextInt();

				// check if input is within given range
				if (input >= bottom && input <= top) {
					sc.nextLine();
					return input;
				} else {
					System.out.println("Please try again.");
				}
			} catch (Exception e) {
				System.out.println("Please try again");
			}
		}
	}
}
