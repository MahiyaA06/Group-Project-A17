import swiftbot.*;

public class ContinueQuitScreen {
	private static final SwiftBotAPI bot = SwiftBotAPI.INSTANCE;
	public static void showContinue_QuitScreen() {
	    
System.out.println("===============================");
System.out.println("    CONTINUE OR QUIT GAME ?    ");
System.out.println("===============================");
System.out.println("                               ");
System.out.println("                               ");
System.out.println("          A = Continue         ");
System.out.println("          B = Quit Game        ");
System.out.println("===============================");
		bot.enableButton(Button.A, () -> {
		
			continueGame();
		
		});
	
	bot.enableButton(Button.B, () -> {
		
		showGame_OverScreen();
	});}
	
	public static void continueGame() {
		System.out.println("Continuing game...");
	}

	public static void showGame_OverScreen() {
System.out.println("===============================");
System.out.println("Sorry You Lost, "
		+ "See you again later.");
System.exit(0);
	}

}
