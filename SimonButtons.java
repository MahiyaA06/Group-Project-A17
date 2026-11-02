import swiftbot.*;
public class SimonButtons {
	private static final SwiftBotAPI bot = SwiftBotAPI.INSTANCE;
	
	static int[][] colours = {{255, 0, 0}, {0, 0, 255}, {255, 255, 0}, {0, 255, 0}};
	//0 =red, 1 =blue, 2 =yellow, 3 =green
	
	static int[] button_Assignments = {0,1,2,3};
	public static void main(String[] args) {
		bot.enableButton(Button.A, () ->{
		try {
		bot.setUnderlight(
				Underlight.FRONT_LEFT, colours[button_Assignments[0]]);
		Thread.sleep(500);
		
		bot.disableUndelights();
		
			}catch
		(InterruptedException e) {
				System.out.println("Error flashing LED");
			}
		});
		
		bot.enableButton(Button.B, () ->{
		try {
		bot.setUnderlight(
					Underlight.FRONT_RIGHT, colours[button_Assignments[1]]);
		Thread.sleep(500);
			
		bot.disableUndelights();
			
			}catch
		(InterruptedException e) {
				System.out.println("Error flashing LED");
				}
			});

		bot.enableButton(Button.X, () ->{
		try {
		bot.setUnderlight(
					Underlight.FRONT_LEFT, colours[button_Assignments[2]]);
		Thread.sleep(500);
				
		bot.disableUndelights();
				
			}catch
		(InterruptedException e) {
				System.out.println("Error flashing LED");
					}
				});
				
		bot.enableButton(Button.Y, () ->{
		try {
		bot.setUnderlight(
					Underlight.FRONT_LEFT, colours[button_Assignments[3]]);
		Thread.sleep(500);
					
		bot.disableUndelights();
					
			}catch
		(InterruptedException e) {
					System.out.println("Error flashing LED");
						}
					});
					
					while (true ) {
					}
		}
}