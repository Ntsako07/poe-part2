package message.pkgclass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Message {

    // =========================
    // ATTRIBUTES / VARIABLES
    // =========================

    // Stores the unique 10-digit message ID
    private final String messageID;

    // Stores the number of messages sent
    private final int numMessagesSent;

    // Stores the recipient cell number
    private final String recipient;

    // Stores the actual message text
    private final String message;

    // Stores the generated message hash
    private final String messageHash;

    // ArrayList used to store all sent messages
    private static final List<Message> sentMessages = new ArrayList<>();


    // =========================
    // CONSTRUCTOR
    // =========================

    /*
     * Constructor used to create a Message object
     * Automatically generates:
     * - Message ID
     * - Message Hash
     */
    public Message(int numMessagesSent,
                   String recipient,
                   String message) {

        // Generate random message ID
        this.messageID = generateMessageID();

        // Assign message number
        this.numMessagesSent = numMessagesSent;

        // Assign recipient
        this.recipient = recipient;

        // Assign message text
        this.message = message;

        // Generate hash
        this.messageHash = createMessageHash();
    }


    // =========================
    // GENERATE MESSAGE ID
    // =========================

    /*
     * Generates a random 10-digit message ID
     */
    private String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }


    // =========================
    // CHECK MESSAGE ID
    // =========================

    /*
     * Checks if Message ID contains
     * exactly 10 digits
     */
    public boolean checkMessageID() {

        return messageID.length() == 10;
    }


    // =========================
    // CHECK RECIPIENT NUMBER
    // =========================

    /*
     * Validates recipient cell number
     * Requirements:
     * - Must start with +
     * - Must not exceed 10 characters
     */
    public String checkRecipientCell() {

        if (recipient != null
                && recipient.startsWith("+")
                && recipient.length() <= 10
                && recipient.length() > 1) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number incorrectly formatted.";
        }
    }


    // =========================
    // VALIDATE MESSAGE LENGTH
    // =========================

    /*
     * Checks whether the message
     * exceeds 250 characters
     */
    public String validateMessage() {

        if (message.length() > 250) {

            return "Please enter a message of less than 250 characters.";

        } else {

            return "Message sent";
        }
    }


    // =========================
    // CREATE MESSAGE HASH
    // =========================

    /*
     * Creates a message hash using:
     * - First 2 digits of Message ID
     * - Message number
     * - First word of message
     * - Last word of message
     *
     * Example:
     * 12:1:HITHANKS
     */
    public String createMessageHash() {

        // First 2 digits of Message ID
        String firstTwoDigits = messageID.substring(0, 2);

        // Convert message number to String
        String messageNumber =
                String.valueOf(numMessagesSent);

        // Split message into words
        String[] words =
                message.trim().split("\\s+");

        // First word
        String firstWord =
                words[0].toUpperCase();

        // Last word
        String lastWord =
                words[words.length - 1].toUpperCase();

        // Return final hash
        return firstTwoDigits
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }


    // =========================
    // SEND MESSAGE METHOD
    // =========================

    /*
     * Allows user to:
     * 1 - Send Message
     * 2 - Disregard Message
     * 3 - Store Message
     */
    public String sentMessage() {

        Scanner scanner = new Scanner(System.in);

        // Display menu
        System.out.println("\nChoose an option:");
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message to send later");

        // Read option
        int option = scanner.nextInt();

        switch (option) {

            // SEND MESSAGE
            case 1:

                // Add to sent messages list
                sentMessages.add(this);

                return "Message successfully sent.";

            // DISREGARD MESSAGE
            case 2:

                return "Press 0 to delete the message.";

            // STORE MESSAGE
            case 3:

                storeMessage();

                return "Message successfully stored.";

            // INVALID OPTION
            default:

                return "Invalid option selected.";
        }
    }


    // =========================
    // STORE MESSAGE IN JSON FILE
    // =========================

    /*
     * Stores message details
     * inside a JSON file
     */
    public void storeMessage() {

        try (FileWriter writer =
                     new FileWriter(
                             "storedMessages.json",
                             true)) {

            // JSON format
            String json =
                    "{\n"
                            + "\"MessageID\": \""
                            + messageID
                            + "\",\n"

                            + "\"MessageHash\": \""
                            + messageHash
                            + "\",\n"

                            + "\"Recipient\": \""
                            + recipient
                            + "\",\n"

                            + "\"Message\": \""
                            + message
                            + "\"\n"

                            + "}\n";

            // Write to file
            writer.write(json);

        } catch (IOException e) {

            System.out.println(
                    "Error writing to JSON file.");
        }
    }


    // =========================
    // PRINT ALL SENT MESSAGES
    // =========================

    /*
     * Displays all sent messages
     */
    public static String printMessages() {

        StringBuilder output =
                new StringBuilder();

        // Loop through messages
        for (Message msg : sentMessages) {

            output.append(
                    "\n--------------------------------\n");

            output.append("Message ID: ")
                    .append(msg.messageID)
                    .append("\n");

            output.append("Message Hash: ")
                    .append(msg.messageHash)
                    .append("\n");

            output.append("Recipient: ")
                    .append(msg.recipient)
                    .append("\n");

            output.append("Message: ")
                    .append(msg.message)
                    .append("\n");
        }

        return output.toString();
    }


    // =========================
    // RETURN TOTAL MESSAGES
    // =========================

    /*
     * Returns total messages sent
     */
    public static int returnTotalMessages() {

        return sentMessages.size();
    }


    // =========================
    // GETTERS
    // =========================

    public String getMessageID() {

        return messageID;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getMessage() {

        return message;
    }

    public String getMessageHash() {

        return messageHash;
    }


    // =========================
    // MAIN METHOD
    // =========================

    /*
     * Program execution starts here
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Message counter
        int messageCount = 1;

        // Recipient number
        System.out.println(
                "Enter recipient number:");

        String recipient =
                scanner.nextLine();

        // Message text
        System.out.println(
                "Enter your message:");

        String textMessage =
                scanner.nextLine();

        // Create Message object
        Message msg = new Message(
                messageCount,
                recipient,
                textMessage
        );

        // Display details
        System.out.println(
                "\nMESSAGE DETAILS");

        System.out.println(
                "---------------------------");

        // Validation results
        System.out.println(
                "Valid Message ID: "
                        + msg.checkMessageID());

        System.out.println(
                msg.checkRecipientCell());

        System.out.println(
                msg.validateMessage());

        // Message hash
        System.out.println(
                "Message Hash: "
                        + msg.getMessageHash());

        // Send/store/disregard
        System.out.println(
                msg.sentMessage());

        // Display sent messages
        System.out.println(
                "\nALL SENT MESSAGES");

        System.out.println(
                printMessages());

        // Total messages
        System.out.println(
                "Total Messages Sent: "
                        + returnTotalMessages());
    }
}