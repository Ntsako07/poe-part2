package message.pkgclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class unittest {

    // =========================
    // LOGIN TESTS
    // =========================

    @Test
    void testLoginSuccess() {

        boolean result =
                QuickChat.loginUser(
                        "admin",
                        "Pass@123"
                );

        assertTrue(result);
    }

    @Test
    void testLoginWrongUsername() {

        boolean result =
                QuickChat.loginUser(
                        "wrongUser",
                        "Pass@123"
                );

        assertFalse(result);
    }

    @Test
    void testLoginWrongPassword() {

        boolean result =
                QuickChat.loginUser(
                        "admin",
                        "wrongPass"
                );

        assertFalse(result);
    }

    @Test
    void testLoginWrongUsernameAndPassword() {

        boolean result =
                QuickChat.loginUser(
                        "wrongUser",
                        "wrongPass"
                );

        assertFalse(result);
    }


    // =========================
    // RECIPIENT VALIDATION TESTS
    // =========================

    @Test
    void testValidRecipient() {

        assertTrue(
                QuickChat.isValidRecipient("+27821234")
        );

        assertTrue(
                QuickChat.isValidRecipient("+12345678")
        );
    }

    @Test
    void testRecipientTooLong() {

        assertFalse(
                QuickChat.isValidRecipient("+27821234567")
        );
    }

    @Test
    void testRecipientWithoutPlus() {

        assertFalse(
                QuickChat.isValidRecipient("082123456")
        );
    }

    @Test
    void testRecipientEmpty() {

        assertFalse(
                QuickChat.isValidRecipient("")
        );
    }

    @Test
    void testRecipientNull() {

        assertFalse(
                QuickChat.isValidRecipient(null)
        );
    }


    // =========================
    // MESSAGE ID TESTS
    // =========================

    @Test
    void testGeneratedMessageIDLength() {

        String id =
                QuickChat.generateMessageID();

        assertEquals(10, id.length());
    }

    @Test
    void testGeneratedMessageIDContainsOnlyNumbers() {

        String id =
                QuickChat.generateMessageID();

        assertTrue(id.matches("\\d+"));
    }


    // =========================
    // MESSAGE HASH TESTS
    // =========================

    @Test
    void testMessageHashBasic() {

        String result =
                QuickChat.createMessageHash(
                        "0012345678",
                        1,
                        "Hi thanks"
                );

        assertEquals(
                "00:1:HITHANKS",
                result
        );
    }

    @Test
    void testMessageHashSingleWord() {

        String result =
                QuickChat.createMessageHash(
                        "9912345678",
                        5,
                        "Hello"
                );

        assertEquals(
                "99:5:HELLOHELLO",
                result
        );
    }

    @Test
    void testMessageHashMultipleWords() {

        String result =
                QuickChat.createMessageHash(
                        "5512345678",
                        2,
                        "Good morning world"
                );

        assertEquals(
                "55:2:GOODWORLD",
                result
        );
    }

    @Test
    void testMessageHashMultipleSpaces() {

        String result =
                QuickChat.createMessageHash(
                        "6612345678",
                        3,
                        "Good    morning     world"
                );

        assertEquals(
                "66:3:GOODWORLD",
                result
        );
    }

    @Test
    void testMessageHashLowerCase() {

        String result =
                QuickChat.createMessageHash(
                        "7712345678",
                        10,
                        "testing lowercase"
                );

        assertEquals(
                "77:10:TESTINGLOWERCASE",
                result
        );
    }

    @Test
    void testMessageHashUpperCase() {

        String result =
                QuickChat.createMessageHash(
                        "8812345678",
                        7,
                        "HELLO WORLD"
                );

        assertEquals(
                "88:7:HELLOWORLD",
                result
        );
    }

    @Test
    void testMessageHashWithPunctuation() {

        String result =
                QuickChat.createMessageHash(
                        "1212345678",
                        3,
                        "Hi, how are you?"
                );

        assertEquals(
                "12:3:HI,YOU?",
                result
        );
    }

    @Test
    void testMessageHashSpecialCharacters() {

        String result =
                QuickChat.createMessageHash(
                        "3312345678",
                        1,
                        "Wow!!! Great."
                );

        assertEquals(
                "33:1:WOW!!!GREAT.",
                result
        );
    }

    @Test
    void testMessageHashLeadingSpaces() {

        String result =
                QuickChat.createMessageHash(
                        "4412345678",
                        4,
                        "   Hello world"
                );

        assertEquals(
                "44:4:HELLOWORLD",
                result
        );
    }

    @Test
    void testMessageHashTrailingSpaces() {

        String result =
                QuickChat.createMessageHash(
                        "5512345678",
                        8,
                        "Hello world     "
                );

        assertEquals(
                "55:8:HELLOWORLD",
                result
        );
    }


    // =========================
    // EXTRA EDGE CASE TESTS
    // =========================

    @Test
    void testGeneratedIDsAreDifferent() {

        String id1 =
                QuickChat.generateMessageID();

        String id2 =
                QuickChat.generateMessageID();

        assertNotEquals(id1, id2);
    }

    @Test
    void testRecipientMinimumLength() {

        assertTrue(
                QuickChat.isValidRecipient("+1")
        );
    }

    @Test
    void testRecipientOnlyPlusFails() {

        assertFalse(
                QuickChat.isValidRecipient("+")
        );
    }
}