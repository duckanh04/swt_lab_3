import org.example.Add;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {

    File file1 = new File(System.getProperty("user.dir") + "/src/main/java/org/example/contacts.txt");// we get the file
    BufferedReader reader1 = new BufferedReader(new FileReader(file1)); // we get reader for the file

    OutputStreamWriter writer1 = new OutputStreamWriter(
            new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/org/example/contacts.txt", true), "UTF-8");
    BufferedWriter writer = new BufferedWriter(writer1);//this is a way to get a writer for th specific file
    boolean duplicate, valid;

    public AddTest() throws FileNotFoundException, UnsupportedEncodingException {
    }

    // Test 1
    @Test
    void phone210123456ShouldReturnTrue() throws IOException {
        boolean check = Add.isPhoneDuplicate(reader1, duplicate, 210123456);
        assertTrue(check);
    }

    @Test
    void phone21012345ShouldReturnFalse() throws IOException {
        boolean check = Add.isPhoneDuplicate(reader1, duplicate, 21012345);
        assertFalse(check);
    }

    @Test
    void phon0849070802ShouldReturnFalse() throws IOException {
        boolean check = Add.isPhoneDuplicate(reader1, duplicate, 49070802);
        assertFalse(check);
    }

    // Test 2
    @Test
    void phone123456ShouldReturnTrue() throws IOException {
        boolean check = Add.isMobilePhoneDuplicated(reader1, duplicate, 123456);
        assertTrue(check);
    }

    @Test
    void phone12232ShouldReturnFalse() throws IOException {
        boolean check = Add.isMobilePhoneDuplicated(reader1, duplicate, 12232);
        assertFalse(check);
    }

    // Test 3
    @Test
    void shouldReturnMinhKhai()
    {
        String address = Add.getAddress("MinhKhai");
        assertEquals("MinhKhai", address);
    }

    @Test
    void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Add.getAddress(""));
    }

    // Test 4
    @Test
    void mailpeteShouldReturnTrue() throws IOException {
        boolean check = Add.isMailDuplicated(reader1, duplicate, "pete@mail.com");
        assertTrue(check);
    }

    @Test
    void mailpetShouldReturnFalse() throws IOException {
        boolean check = Add.isMailDuplicated(reader1, duplicate, "pet@mail.com");
        assertFalse(check);
    }

    // Test 5
    @Test
    void shouldReturn1001() {
        int result = Add.getZipCode(0, "1001");
        assertEquals(1001, result);
    }

    @Test
    void ABCshouldThrowNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> Add.getZipCode(0, "ABC"));
    }

    @Test
    void shouldReturnNull() {
        assertNull(Add.getZipCode(0, "-5"));
    }



}
