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
		
		System.out.println("===============================");
		System.out.println("       SIMON MEMORY GAME!      ");
		System.out.println("===============================");
		System.out.println("");
		System.out.println("RULES OF THE GAME: ");
		System.out.println("");
		System.out.println("1) Repeat the order identically to the colours on the bot");
		System.out.println("2) You only get  lives before GAME OVER");
		System.out.println("3) You will get the choice to continue or leave the game");
		System.out.println("");
		System.out.println("===============================");
		
		try {
			LoopsForRound();
		}
		catch (Exception e) {
			
		}

	}

	static int[][] colours = { { 255, 0, 0 }, { 0, 0, 255 }, { 255, 255, 0 }, { 0, 255, 0 } };
	// 0 =red, 1 =blue, 2 =yellow, 3 =green

	static int[] button_Assignments = { 0, 1, 2, 3 };

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
						System.out.println("Correct! Next round.");
						addNewColour = true;
						round += 1;
						score += 1;
						
						if ((round % 5 == 0) && (round != 0)) {
							showContinue_QuitScreen();
						}
						else {
								
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
