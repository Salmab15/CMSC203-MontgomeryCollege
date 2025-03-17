
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple "substitution cipher" where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
     * This method determines if a string is within the allowable bounds of ASCII codes 
     * according to the LOWER_RANGE and UPPER_RANGE characters
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean isStringInBounds(String plainText) {
        // Iterate through each character in the input string
        for (int i = 0; i < plainText.length(); i++) {
            // Check if the character is outside the defined range
            if (plainText.charAt(i) > UPPER_RANGE || plainText.charAt(i) < LOWER_RANGE) {
                return false; // Return false if characters are out of bounds
            }
        }
        return true; // Return true if all characters are in bounds
    }

    /**
     * Encrypts a string using the Caesar Cipher.
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String caesarEncryption(String plainText, int key) {
        // Check if plainText is within bounds
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        // Maintain key bounds
        key = key % RANGE;
        if (key < 0) {
            key += RANGE;
        }

        // Declare char array for input
        char[] textArray = new char[plainText.length()];

        // Iterate through each character in plainText
        for (int i = 0; i < plainText.length(); i++) {
            // Shift character by key value
            textArray[i] = (char) (plainText.charAt(i) + key);

            // Adjust if character goes beyond upper range
            while (textArray[i] > UPPER_RANGE) {
                textArray[i] -= RANGE;
            }

            // Adjust if character goes below lower range
            while (textArray[i] < LOWER_RANGE) {
                textArray[i] += RANGE;
            }
        }

        // Return encrypted text as string
        return String.copyValueOf(textArray);
    }

    /**
     * Encrypts a string using the Bellaso Cipher.
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets.
     * @return the encrypted string
     */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        // Check if plainText is within bounds
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }

        // Create an array for repeating key pattern
        char[] keyArray = new char[plainText.length()];
        int length = 0;

        // Populate keyArray with repeating bellasoStr characters
        while (length < plainText.length()) {
            keyArray[length] = bellasoStr.charAt(length % bellasoStr.length());
            length++;
        }

        // Declare char array for encrypted text
        char[] textArray = new char[plainText.length()];

        // Iterate through each character in plainText
        for (int i = 0; i < plainText.length(); i++) {
            // Shift character using corresponding keyArray value
            textArray[i] = (char) (plainText.charAt(i) + keyArray[i]);

            // Adjust if character goes beyond upper range
            while (textArray[i] > UPPER_RANGE) {
                textArray[i] -= RANGE;
            }

            // Adjust if character goes below lower range
            while (textArray[i] < LOWER_RANGE) {
                textArray[i] += RANGE;
            }
        }

        // Return encrypted text as string
        return String.copyValueOf(textArray);
    }

    /**
     * Decrypts a string encrypted using the Caesar Cipher.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the decrypted string
     */
    public static String caesarDecryption(String encryptedText, int key) {
        // Check if encryptedText is within bounds
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }

        // Maintain key bounds 
        key = key % RANGE;
        if (key < 0) {
            key += RANGE;
        }

        // Declare a character array for decrypted text
        char[] textArray = new char[encryptedText.length()];

        // Iterate through each character in encryptedText
        for (int i = 0; i < encryptedText.length(); i++) {
            // Reverse shift character by key value
            textArray[i] = (char) (encryptedText.charAt(i) - key);

            // Adjust if character goes beyond upper range
            while (textArray[i] > UPPER_RANGE) {
                textArray[i] -= RANGE;
            }

            // Adjust if character goes below lower range
            while (textArray[i] < LOWER_RANGE) {
                textArray[i] += RANGE;
            }
        }

        // Return decrypted text as string
        return String.copyValueOf(textArray);
    }
}
