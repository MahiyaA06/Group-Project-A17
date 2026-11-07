package programs;
import java.util.Scanner;

public class StartScreen {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Welcome to the game!");
		System.out.println("Play or quit?");
		String ans1 = myObj.nextLine();
		if (ans1 == "Play") {
			System.out.println("Have fun!");
			//will be replaced with a file path to the actual game
		} else if (ans1 == "Quit"){
			System.out.println("See you again champ!");
		} else {
			System.out.println("Please input either play or quite.");
		}

	}

}
