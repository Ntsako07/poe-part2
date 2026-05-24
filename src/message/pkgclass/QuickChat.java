package message.pkgclass;

import java.util.Random;
import java.util.Scanner;

public class QuickChat {

    // Scanner for user input
    static Scanner input = new Scanner(System.in);

    // Stored login details
    static String storedUsername = "admin";
    static String storedPassword = "Pass@123";

    // Total messages sent
    static int totalMessagesSent = 0;

    // =========================
    // LOGIN METHOD
    // =========================

    public static boolean loginUser(String username, String password) {

        return username.equals(storedUsername)
                && password.equals(storedPassword);
    }

    // =========================
    // VALIDATE RECIPIENT NUMBER
    // =========================

    public static boolean isValidRecipient(String recipient) {

        return recipient != null
                && recipient.startsWith("+")
                && recipient.length() <= 10
                && recipient.length() > 1;
    }

    // =========================
    // GENERATE RANDOM MESSAGE ID
    // =========================

    public static String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // =========================
    // CREATE MESSAGE HASH
    // =========================

    public static String createMessageHash(String messageID,
                                           int messageNumber,
                                           String message) {

        // Split message correctly even with multiple spaces
        String[] words = message.trim().split("\\s+");

        // First word
        String firstWord = words[0];

        // Last word
        String lastWord = words[words.length - 1];

        // Return hash format
        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        System.out.println("===== QUICKCHAT LOGIN =====");

        // USERNAME
        System.out.print("Enter username: ");
        String username = input.nextLine();

        // PASSWORD
        System.out.print("Enter password: ");
        String password = input.nextLine();

        // LOGIN CHECK
        boolean loginStatus = loginUser(username, password);

        if (loginStatus) {

            System.out.println("\nWelcome to QuickChat.");

            // NUMBER OF MESSAGES
            System.out.print("\nHow many messages would you like to send? ");
            int maxMessages = input.nextInt();
            input.nextLine();

            int sentMessages = 0;

            // MENU LOOP
            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                System.out.print("Choose an option: ");

                int option = input.nextInt();
                input.nextLine();

                switch (option) {

                    // =========================
                    // SEND MESSAGE
                    // =========================

                    case 1:

                        if (sentMessages >= maxMessages) {

                            System.out.println("Message limit reached.");
                            break;
                        }

                        // RECIPIENT NUMBER
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        if (!isValidRecipient(recipient)) {

                            System.out.println(
                                    "Cell phone number incorrectly formatted.");

                            break;
                        }

                        // MESSAGE
                        System.out.print("Enter your message: ");
                        String message = input.nextLine();

                        // MESSAGE LENGTH VALIDATION
                        if (message.length() > 250) {

                            System.out.println(
                                    "Please enter a message of less than 250 characters.");

                            break;

                        } else {

                            System.out.println("Message ready to send.");
                        }

                        // GENERATE MESSAGE ID
                        String messageID = generateMessageID();

                        // GENERATE HASH
                        String hash = createMessageHash(
                                messageID,
                                sentMessages + 1,
                                message
                        );

                        // SEND OPTIONS
                        System.out.println("\nChoose option:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message to send later");

                        int choice = input.nextInt();
                        input.nextLine();

                        // OPTION 1: SEND
                        if (choice == 1) {

                            System.out.println(
                                    "Message successfully sent.");

                            sentMessages++;
                            totalMessagesSent++;

                            // DISPLAY MESSAGE DETAILS
                            System.out.println("\n===== MESSAGE DETAILS =====");

                            System.out.println("Message ID: "
                                    + messageID);

                            System.out.println("Message Hash: "
                                    + hash);

                            System.out.println("Recipient: "
                                    + recipient);

                            System.out.println("Message: "
                                    + message);

                        }

                        // OPTION 2: DISREGARD
                        else if (choice == 2) {

                            System.out.println(
                                    "Press 0 to delete the message.");
                        }

                        // OPTION 3: STORE
                        else if (choice == 3) {

                            System.out.println(
                                    "Message successfully stored.");
                        }

                        // INVALID OPTION
                        else {

                            System.out.println("Invalid option.");
                        }

                        break;

                    // =========================
                    // SHOW RECENT MESSAGES
                    // =========================

                    case 2:

                        System.out.println("Coming Soon.");
                        break;

                    // =========================
                    // QUIT PROGRAM
                    // =========================

                    case 3:

                        System.out.println(
                                "\nTotal messages sent: "
                                        + totalMessagesSent);

                        System.out.println("Exiting QuickChat...");
                        System.exit(0);

                        break;

                    // =========================
                    // INVALID MENU OPTION
                    // =========================

                    default:

                        System.out.println("Invalid option.");
                }
            }

        }

        // LOGIN FAILED
        else {

            System.out.println(
                    "Username or password incorrect.");
        }
    }
}