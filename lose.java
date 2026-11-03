
public class lose {
	public static boolean GameOver(int lives) {
		if (lives == 0) {
			
			ContinueQuitScreen.showGame_OverScreen();
		}
		return true;
	}
}
