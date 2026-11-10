import swiftbot.*;
 
public class ColourChanger {
 
    // Each colour as {red, green, blue}, from 0 to 255
    static int red    = {255, 0, 0};
    static int blue   = {0, 0, 255};
    static int yellow = {255, 255, 0};
    static int green  = {0, 255, 0};
 
    // Turns one LED on with a colour, waits, then turns it off
    public static void flash(SwiftBotAPI bot, Underlight led, int[] colour) throws InterruptedException {
        bot.setUnderlight(led, colour);
        Thread.sleep(700);          // stay on for 0.7 seconds
        bot.disableUnderlights();
        Thread.sleep(300);          // short gap before the next colour
    }
 
    public static void main(String[] args) throws InterruptedException {
        SwiftBotAPI bot = new SwiftBotAPI();
 
        flash(bot, Underlight.FRONT_LEFT,  red);     // button A
        flash(bot, Underlight.FRONT_RIGHT, blue);    // button X
        flash(bot, Underlight.BACK_LEFT,   yellow);  // button B
        flash(bot, Underlight.BACK_RIGHT,  green);   // button Y
 
        System.exit(0);
    }
}
