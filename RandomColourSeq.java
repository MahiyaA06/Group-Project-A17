// ChatGPT prompt used to generate the following code: 'Can you please help me simply and step-by-step, as a Java beginner, to code this flowchart in Java about the Brunel University SwiftBot robot emulating the Simon memory game in order to display a random colour sequence for the user to press and be able to play the game?

// Please also use the image, SwiftBot API version 6 file, and the following index of SwiftBot commands from Reposilite- JavaDoc to write your code, and explain all of it simply, step-by-step, and line by line for me to understand the code, how it works and how to code the flowchart myself?

// Image of random colour sequence generation flowchart: https://brunel365-my.sharepoint.com/:i:/r/personal/2621129_brunel_ac_uk/Documents/a17group/Random%20Colour%20Sequence%20Generation%20Flowchart.png?d=w802adbf7911241c2868366f2fb13224a&csf=1&web=1&e=UAARNx
// SwiftBot API version 6: https://brunel365-my.sharepoint.com/:u:/r/personal/2621129_brunel_ac_uk/Documents/a17group/SwiftBot-API-6.0.0.zip?d=w3f78cf616bab48fe92c1ecefc2db3ab5&csf=1&web=1&e=KYzpiz

// Index:

// A
// A - Enum constant in enum class swiftbot.Button
 
// B
// B - Enum constant in enum class swiftbot.Button
 
// BACK_LEFT - Enum constant in enum class swiftbot.Underlight
// Controls the back left SwiftBot underlight.
// BACK_RIGHT - Enum constant in enum class swiftbot.Underlight
// Controls the back right SwiftBot underlight.
// Button - Enum Class in swiftbot
// An Enum used to create and select which physical button on the SwiftBot will be interacted with.
// ButtonFunction - Interface in swiftbot
// A functional interface containing a user defined function.
// D
// decodeQRImage(BufferedImage) - Method in enum class swiftbot.SwiftBotAPI
// Detects a QR code within an image taken with captureFeed()
// disable() - Method in enum class swiftbot.Underlight
// Disables the underlight, setting its RGB intensity to 0.
// disableAllButtons() - Method in enum class swiftbot.SwiftBotAPI
// Disables all SwiftBot Buttons, removing all associated ButtonFunctions.
// disableButton(Button) - Method in enum class swiftbot.SwiftBotAPI
// Disables the passed in Button.
// disableButtonLights() - Method in enum class swiftbot.SwiftBotAPI
// Powers off all SwiftBot button lights.
// disableUnderlight(Underlight) - Method in enum class swiftbot.SwiftBotAPI
// Disables the passed in Underlight.
// disableUnderlights() - Method in enum class swiftbot.SwiftBotAPI
// Disables all SwiftBot Underlights.
// E
// enableButton(Button, ButtonFunction) - Method in enum class swiftbot.SwiftBotAPI
// Enables the passed in Button, assigning the button press functionality to the passed in ButtonFunction.
// F
// fillButtonLights() - Method in enum class swiftbot.SwiftBotAPI
// Powers on all SwiftBot button lights.
// fillUnderlights(int[]) - Method in enum class swiftbot.SwiftBotAPI
// Sets all Underlights to the passed in RGB value.
// FRONT_LEFT - Enum constant in enum class swiftbot.Underlight
// Controls the front left SwiftBot underlight.
// FRONT_RIGHT - Enum constant in enum class swiftbot.Underlight
// Controls the front right SwiftBot underlight.
// G
// getButtonLightState(Button) - Method in enum class swiftbot.SwiftBotAPI
// Checks if the given button light is currently enabled.
// getColour() - Method in enum class swiftbot.Underlight
// Returns the intensities of the RGB LEDs of this Underlight as an int[].
// getQRImage() - Method in enum class swiftbot.SwiftBotAPI
// Takes a snapshot with the Camera for Image Recognition processing.
// getVersion() - Method in enum class swiftbot.SwiftBotAPI
// Returns the current semantic version of the SwiftBotAPI as a String.
// I
// ImageSize - Enum Class in swiftbot
// Image sizes that can be used when capturing an image using the SwiftBot's camera.
// INSTANCE - Enum constant in enum class swiftbot.SwiftBotAPI
// The singleton instance of the SwiftBotAPI controller.
// M
// MIDDLE_LEFT - Enum constant in enum class swiftbot.Underlight
// Controls the middle left SwiftBot underlight.
// MIDDLE_RIGHT - Enum constant in enum class swiftbot.Underlight
// Controls the middle right SwiftBot underlight.
// move(int, int, int) - Method in enum class swiftbot.SwiftBotAPI
// Powers the SwiftBot's motors (at a velocity selected by leftVelocity and rightVelocity) for movementTime milliseconds.
// R
// run() - Method in interface swiftbot.ButtonFunction
// A user-defined method that will be run upon button press.
// S
// setButtonLight(Button, Boolean) - Method in enum class swiftbot.SwiftBotAPI
// Sets the button light associated with the passed in Button to the passed in boolean state.
// setColour(int[]) - Method in enum class swiftbot.Underlight
// Sets the intensity of this underlight to a user-defined value between 0 and 255.
// setUnderlight(Underlight, int[]) - Method in enum class swiftbot.SwiftBotAPI
// Sets the passed in underlight to the passed in RGB value.
// SQUARE_1080x1080 - Enum constant in enum class swiftbot.ImageSize
// Incredibly large image size (1080x1080)
// SQUARE_144x144 - Enum constant in enum class swiftbot.ImageSize
// Small image size (144x144)
// SQUARE_240x240 - Enum constant in enum class swiftbot.ImageSize
// Medium image size (240x240)
// SQUARE_480x480 - Enum constant in enum class swiftbot.ImageSize
// Large image size (480x480)
// SQUARE_48x48 - Enum constant in enum class swiftbot.ImageSize
// Extra small image size (48x48)
// SQUARE_720x720 - Enum constant in enum class swiftbot.ImageSize
// Extra large image size (720x720)
// startMove(int, int) - Method in enum class swiftbot.SwiftBotAPI
// Powers the SwiftBot's motors (at a velocity selected by leftVelocity and rightVelocity) indefinitely.
// stopMove() - Method in enum class swiftbot.SwiftBotAPI
// Powers all the SwiftBot's motors off.
// swiftbot - package swiftbot
 
// SwiftBotAPI - Enum Class in swiftbot
// An API (Application Programming Interface) allowing easy interaction with the SwiftBots' various features and functionalities.
// T
// takeGrayscaleStill(ImageSize) - Method in enum class swiftbot.SwiftBotAPI
// Uses the SwiftBot's camera to take a picture and returns it as a BufferedImage.
// takeStill(ImageSize) - Method in enum class swiftbot.SwiftBotAPI
// Uses the SwiftBot's camera to take a picture and returns it as a BufferedImage.
// toggleButtonLight(Button) - Method in enum class swiftbot.SwiftBotAPI
// Toggles the button light associated with the passed in Button.
// U
// Underlight - Enum Class in swiftbot
// Each Underlight controls one of the six lights found on the underside of the SwiftBot (FRONT_LEFT, FRONT_RIGHT, MIDDLE_LEFT, MIDDLE_RIGHT, BACK_LEFT, and BACK_RIGHT).
// useUltrasound() - Method in enum class swiftbot.SwiftBotAPI
// Uses the SwiftBot's ultrasound sensor to calculate the distance from the front of the SwiftBot to its nearest obstacle.
// V
// valueOf(String) - Static method in enum class swiftbot.Button
// Returns the enum constant of this class with the specified name.
// valueOf(String) - Static method in enum class swiftbot.ImageSize
// Returns the enum constant of this class with the specified name.
// valueOf(String) - Static method in enum class swiftbot.SwiftBotAPI
// Returns the enum constant of this class with the specified name.
// valueOf(String) - Static method in enum class swiftbot.Underlight
// Returns the enum constant of this class with the specified name.
// values() - Static method in enum class swiftbot.Button
// Returns an array containing the constants of this enum class, in the order they are declared.
// values() - Static method in enum class swiftbot.ImageSize
// Returns an array containing the constants of this enum class, in the order they are declared.
// values() - Static method in enum class swiftbot.SwiftBotAPI
// Returns an array containing the constants of this enum class, in the order they are declared.
// values() - Static method in enum class swiftbot.Underlight
// Returns an array containing the constants of this enum class, in the order they are declared.
// X
// X - Enum constant in enum class swiftbot.Button
 
// Y
// Y - Enum constant in enum class swiftbot.Button'.

package default1;

import swiftbot.SwiftBotAPI;
import swiftbot.Button;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SwiftBot_Random_Colour_Generation {

    static SwiftBotAPI swiftBot = SwiftBotAPI.INSTANCE;
    static Random random = new Random();
    static BlockingQueue<Integer> presses = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

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

            System.out.println("Game over!");

        } finally {
            swiftBot.disableUnderlights();
            swiftBot.disableAllButtons();
        }
    }

    static void flashColour(int colour) throws InterruptedException {

        int[] rgb;

        if (colour == 0) {
            rgb = new int[]{255, 0, 0};
        } else if (colour == 1) {
            rgb = new int[]{0, 0, 255};
        } else if (colour == 2) {
            rgb = new int[]{255, 255, 0};
        } else {
            rgb = new int[]{0, 255, 0};
        }

        swiftBot.fillUnderlights(rgb);
        Thread.sleep(700);
        swiftBot.disableUnderlights();
        Thread.sleep(350);
    }
}
