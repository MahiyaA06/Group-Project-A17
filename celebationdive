import swiftbot.SwiftBotAPI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CelebrationDive {

    private static SwiftBotAPI swiftBot;

    private static final int[] RED = {255, 0, 0};
    private static final int[] GREEN = {0, 255, 0};
    private static final int[] BLUE = {0, 0, 255};
    private static final int[] YELLOW = {255, 255, 0};

    private static final double MAX_SPEED_CM_PER_SEC = 30.0;

    public static void main(String[] args) {
        try {
            swiftBot = new SwiftBotAPI();
        } catch (Exception e) {
            System.out.println("Error initializing SwiftBotAPI.");
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("   SWIFTBOT CELEBRATION DIVE PROGRAM     ");
        System.out.println("=========================================");
        System.out.print("Enter the user's final game score: ");

        if (scanner.hasNextInt()) {
            int score = scanner.nextInt();
            performCelebrationDive(score);
        } else {
            System.out.println("Invalid input. Please enter a whole number for the score.");
        }

        scanner.close();
    }

    public static void performCelebrationDive(int score) {
        int speed;
        if (score < 5) {
            speed = 40;
        } else if (score >= 10) {
            speed = 100;
        } else {
            speed = score * 10;
        }

        System.out.println("\n--- Celebration Dive Summary ---");
        System.out.println("User Score: " + score);
        System.out.println("Calculated Speed: " + speed + "%");
        System.out.println("V-Shape Arm Length: 30 cm");
        System.out.println("--------------------------------\n");

        try {
            System.out.println("[Phase 1] Blinking 4 game colours in random order...");
            blinkRandomColours();

            System.out.println("[Phase 2] Performing 30 cm 'V' shape dive with flashing lights...");
            driveVShapeWithFlashingLights(speed);

            System.out.println("[Phase 3] Blinking 4 game colours in random order...");
            blinkRandomColours();

            swiftBot.disableUnderlights();
            swiftBot.stopMove();
            System.out.println("\nCelebration dive complete!");

        } catch (InterruptedException | IOException e) {
            System.out.println("An error occurred during the celebration dive: " + e.getMessage());
            swiftBot.stopMove();
        }
    }

    private static void blinkRandomColours() throws IOException, InterruptedException {
        List<int[]> colours = new ArrayList<>();
        colours.add(RED);
        colours.add(GREEN);
        colours.add(BLUE);
        colours.add(YELLOW);

        Collections.shuffle(colours);

        for (int[] colour : colours) {
            System.out.println("  -> Blinking: " + getColourName(colour));
            swiftBot.fillUnderlights(colour);
            Thread.sleep(400);
            swiftBot.disableUnderlights();
            Thread.sleep(200);
        }
    }

    private static void driveVShapeWithFlashingLights(int speed) throws IOException, InterruptedException {
        double actualSpeedCmPerSec = MAX_SPEED_CM_PER_SEC * (speed / 100.0);
        int armDurationMs = (int) ((30.0 / actualSpeedCmPerSec) * 1000);

        System.out.println("  -> Driving first 30 cm arm of 'V'...");
        moveAndFlash(speed, speed, armDurationMs);

        System.out.println("  -> Turning at the vertex of the 'V'...");
        moveAndFlash(60, -60, 650);

        System.out.println("  -> Driving second 30 cm arm of 'V'...");
        moveAndFlash(speed, speed, armDurationMs);

        swiftBot.stopMove();
        swiftBot.disableUnderlights();
    }

    private static void moveAndFlash(int leftVelocity, int rightVelocity, int durationMs)
            throws IOException, InterruptedException {
        int[][] colours = {RED, GREEN, BLUE, YELLOW};
        Random random = new Random();

        swiftBot.startMove(leftVelocity, rightVelocity);

        int elapsed = 0;
        int flashInterval = 150;

        while (elapsed < durationMs) {
            int[] randomColour = colours[random.nextInt(colours.length)];
            swiftBot.fillUnderlights(randomColour);

            int sleepTime = Math.min(flashInterval, durationMs - elapsed);
            Thread.sleep(sleepTime);
            elapsed += sleepTime;
        }

        swiftBot.stopMove();
    }

    private static String getColourName(int[] rgb) {
        if (rgb == RED) return "Red";
        if (rgb == GREEN) return "Green";
        if (rgb == BLUE) return "Blue";
        if (rgb == YELLOW) return "Yellow";
        return "Unknown";
    }
}
