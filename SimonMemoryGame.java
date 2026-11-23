import swiftbot.*;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class DoesMySwiftBotWork {
	static SwiftBotAPI swiftBot;
	// ANSI color codes
	static final String RESET = "\u001B[0m";
	static final String CYAN = "\u001B[36m";
	static final String YELLOW = "\u001B[33m";
	static final String GREEN = "\u001B[32m";
	static final String WHITE = "\u001B[37m";
	static final String BOLD = "\u001B[1m";
	static int score = 0;
	static int round = 0;

	public static void main(String[] args) throws InterruptedException {
		try {
			swiftBot = SwiftBotAPI.INSTANCE;
		} catch (Exception e) {
			/*
			 * Outputs a warning if I2C is disabled. This only needs to be turned on once by
			 * our staff. Let us know if this problem occurs!
			 */
			System.out.println("\nI2C disabled!");
			System.exit(5);
		}

		// --- HEADER (printed once) ---
		System.out.printf("""

				%1$s%2$s***************************************************************%3$s
				%1$s%2$s*                     SWIFTBOT TEST MENU                      *%3$s
				%1$s%2$s***************************************************************%3$s

				""", CYAN, BOLD, RESET);
		Scanner reader = new Scanner(System.in); // Reading from System.in

		// loops main menu after each user action
		while (true) {
			// --- MENU ---
			System.out.printf(
					"%sSelect a feature to test:%s\n\n"
							+ "%s [1] %sTest Camera          %s|%s  [2] %sTest Button Lights\n"
							+ "%s [3] %sTest Ultrasound      %s|%s  [4] %sTest Left Wheel\n"
							+ "%s [5] %sTest Right Wheel     %s|%s  [6] %sTest Buttons\n"
							+ "%s [7] %sTest Underlighting   %s|%s  [8] %sTest QR Code Detection\n"
							+ "%s---------------------------------------------------------------%s\n\n"
							+ "%s [0] %sExit%s\n\n" + "%sEnter a number: %s",
					WHITE, RESET, YELLOW, GREEN, WHITE, YELLOW, GREEN, YELLOW, GREEN, WHITE, YELLOW, GREEN, YELLOW,
					GREEN, WHITE, YELLOW, GREEN, YELLOW, GREEN, WHITE, YELLOW, GREEN, CYAN, RESET, YELLOW, GREEN, RESET,
					WHITE, RESET);

			// reads user input and performs corresponding action
			String ans = reader.next();

			switch (ans) {

			// Testing Camera
			case "1":
				StartUp();
				break;
				
			// Testing Left Wheel
			case "4":
				showContinue_QuitScreen();
				break;
			// Testing Right Wheel

			case "8":
				LoopsForRound();
				break;

			// EXIT
			case "0":
				reader.close();
				System.exit(0);
				break;

			default:
				System.out.println("ERROR: Please enter a valid number.");
				break;
			}
		}
	}

	public static void StartUp() {
		System.out.println("===============================");
		System.out.println("       SIMON MEMORY GAME!      ");
		System.out.println("===============================");
		System.out.println("");
		System.out.println("RULES OF THE GAME: ");
		System.out.println("");
		System.out.println("1) Repeat the order identically to the colours on the bot");
		System.out.println("2) You only get 5 lives before GAME OVER");
		System.out.println("3) You will get the choice to continue or leave the game");
		System.out.println("");
		System.out.println("===============================");

	}

	static int[][] colours = { { 255, 0, 0 }, { 0, 0, 255 }, { 255, 255, 0 }, { 0, 255, 0 } };
	// 0 =red, 1 =blue, 2 =yellow, 3 =green

	static int[] button_Assignments = { 0, 1, 2, 3 };

	public static boolean ShowScreen(int round) {
		if (round % 5 == 0) {
			showContinue_QuitScreen();
			return true;
		}

		return false;

	}

	public static void showContinue_QuitScreen() {
		
		Scanner reader = new Scanner(System.in);

		System.out.println("===============================");
		System.out.println("    CONTINUE OR QUIT GAME ?    ");
		System.out.println("===============================");
		System.out.println("                               ");
		System.out.println("          1 = Continue         ");
		System.out.println("          2 = Quit Game        ");
		System.out.println("                               ");
		System.out.println("===============================");
		
		String ans = reader.nextLine();
		
		try {
			switch (ans) {
			
			case "1":
				LoopsForRound();
				break;
		
			case "2":
				GameOver();
				System.exit(0);
				break;
		
			default:
				System.out.println("ERROR: Please enter a valid number.");
				break;
			}
		}
		catch (Exception e) {
			
		}
	}
	

	static Random random = new Random();
	static BlockingQueue<Integer> presses = new LinkedBlockingQueue<>();

	public static void LoopsForRound() throws InterruptedException {

		int lives = 3;
		String sequence = "";
		boolean addNewColour = true;


		System.out.println("Welcome to SwiftBot Simon!");
		System.out.println("A = Red, X = Blue, B = Yellow, Y = Green");
		System.out.println("You have " + lives + " lives.");

		try {
			swiftBot.enableButton(Button.A, () -> presses.offer(0));
			swiftBot.enableButton(Button.X, () -> presses.offer(1));
			swiftBot.enableButton(Button.B, () -> presses.offer(2));
			swiftBot.enableButton(Button.Y, () -> presses.offer(3));

			while (lives > 0) {

				if (addNewColour) {
					int nextColour = random.nextInt(4);
					sequence = sequence + nextColour;
				}

				System.out.println("Watch the lights! Round " + sequence.length());
				presses.clear();
				Thread.sleep(1000);

				for (int i = 0; i < sequence.length(); i++) {
					int colour = sequence.charAt(i) - '0';
					flashColour(colour);
				}

				System.out.println("Now press the buttons in the same order.");
				presses.clear();
				boolean correct = true;

					for (int i = 0; i < sequence.length(); i++) {
						int expected = sequence.charAt(i) - '0';
						int actual = presses.take();
	
						if (actual != expected) {
							correct = false;
							break;
						}
					}
	
					if (correct) {
						if ((round % 5 == 0) && (round != 0)) {
							showContinue_QuitScreen();
						}
						else {
							System.out.println("Correct! Next round.");
							addNewColour = true;
							round += 1;
							score += 1;
						}
					} else {
						lives--;
						System.out.println("Wrong! Lives left: " + lives);
	
						if (lives > 0) {
							System.out.println("Try the same sequence again.");
							addNewColour = false;
						}
				}
				
				Thread.sleep(600);
			}

			GameOver();

		} finally {
			swiftBot.disableUnderlights();
			swiftBot.disableAllButtons();
		}
	}

	static void flashColour(int colour) throws InterruptedException {

		int[] rgb;

		if (colour == 0) {
			rgb = new int[] { 255, 0, 0 };
		} else if (colour == 1) {
			rgb = new int[] { 0, 0, 255 };
		} else if (colour == 2) {
			rgb = new int[] { 255, 255, 0 };
		} else {
			rgb = new int[] { 0, 255, 0 };
		}

		swiftBot.fillUnderlights(rgb);
		Thread.sleep(700);
		swiftBot.disableUnderlights();
		Thread.sleep(350);
	}
	
	public static void GameOver() {
        System.out.println("===============================");
        System.out.println("           GAME OVER!          ");
        System.out.println("===============================");
        System.out.println("");
        System.out.println("You lost at round: " + round);
        System.out.println("Current Score: " + score);
        System.out.println("");
        System.out.println("===============================");
    }

}
