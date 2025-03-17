import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        assertTrue(CryptoManager.isStringInBounds("LUCKY CHARMS"));
        assertTrue(CryptoManager.isStringInBounds("SHAMROCK SHAKE"));
        assertTrue(CryptoManager.isStringInBounds("POT OF GOLD"));
        assertTrue(CryptoManager.isStringInBounds("ST PATRICKS DAY"));
    }

    @Test
    public void testIsStringInBoundsWithOutOfBoundsStrings() {
        assertFalse(CryptoManager.isStringInBounds("leprechaun")); 
        assertFalse(CryptoManager.isStringInBounds("IRISH\nJIG")); 
        assertFalse(CryptoManager.isStringInBounds("CLOVER`LEAF")); 
        assertFalse(CryptoManager.isStringInBounds("GREEN\tBEER")); 
    }

    @Test
    public void testCaesarEncryption() {
        assertEquals("2<//8\"-<+>86=", CryptoManager.caesarEncryption("LUCKY CHARMS", 10));
        assertEquals("HSFFO!DMMPWFS", CryptoManager.caesarEncryption("GREEN CLOVER", 1));
        assertEquals("^_5[L_]TN\\>^5OLd", CryptoManager.caesarEncryption("ST PATRICKS DAY", 15));

        assertEquals("SHAMROCK", CryptoManager.caesarEncryption("SHAMROCK", CryptoManager.RANGE));
        assertEquals("MFQSFDIBVO", CryptoManager.caesarEncryption("LEPRECHAUN", CryptoManager.RANGE + 1));
    }

    @Test
    public void testCaesarDecryption() {
        assertEquals("LUCKY CHARMS", CryptoManager.caesarDecryption("2<//8\"-<+>86=", 10));
        assertEquals("GREEN CLOVER", CryptoManager.caesarDecryption("HSFFO!DMMPWFS", 1));
        assertEquals("ST PATRICKS DAY", CryptoManager.caesarDecryption("^_5[L_]TN\\>^5OLd", 15));

        assertEquals("SHAMROCK", CryptoManager.caesarDecryption("SHAMROCK", CryptoManager.RANGE));
        assertEquals("LEPRECHAUN", CryptoManager.caesarDecryption("MFQSFDIBVO", CryptoManager.RANGE + 1));
    }

    @Test
    public void testBellasoEncryption() {
        assertEquals("\"15]IQYW*", CryptoManager.bellasoEncryption("SHAMROCK", "IRISH"));
        assertEquals("%#^(VM\\T)Q#$%", CryptoManager.bellasoEncryption("LEPRECHAUN", "CLOVER"));
        assertEquals("=_\"WZVAW^T", CryptoManager.bellasoEncryption("LUCKY GOLD", "GREEN"));
    }

    @Test
    public void testBellasoDecryption() {
        assertEquals("SHAMROCK", CryptoManager.bellasoDecryption("\"15]IQYW*", "IRISH"));
        assertEquals("LEPRECHAUN", CryptoManager.bellasoDecryption("%#^(VM\\T)Q#$%", "CLOVER"));
        assertEquals("LUCKY GOLD", CryptoManager.bellasoDecryption("=_\"WZVAW^T", "GREEN"));
    }

    @Test
    public void testStPatricksEncryption() {
        assertEquals("4-1&#1$$*", CryptoManager.caesarEncryption("IRELAND", 7));
        assertEquals("E_WQ%*]J", CryptoManager.bellasoEncryption("RAINBOW", "GOLD"));
    }

    @Test
    public void testStPatricksDecryption() {
        assertEquals("IRELAND", CryptoManager.caesarDecryption("4-1&#1$$*", 7));
        assertEquals("RAINBOW", CryptoManager.bellasoDecryption("E_WQ%*]J", "GOLD"));
    }
}
