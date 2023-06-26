package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.Change.contact_change;
import static org.example.Change.info_check;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChangeTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to a ByteArrayOutputStream
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }

//    @Test
//    public void chooseField1ShouldRunNameSearch() throws IOException {
//
//        InputStream sysInBackup = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("1\n0\nH\nK".getBytes());
//        System.setIn(in);
//
//        Change changeMock = Mockito.mock(Change.class);
//
//        changeMock.choose_field();
//
//        verify(changeMock, times(1)).name_search();
//
//        System.setIn(sysInBackup);
//    }

    @Test
    public void chooseField2ShouldRunNumberSearch() throws IOException {

        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2\n0\nH\nK".getBytes());
        System.setIn(in);

        Change changeMock = Mockito.mock(Change.class);

        changeMock.choose_field();

        verify(changeMock, times(1)).number_search();

        System.setIn(sysInBackup);
    }

//    @Test
//    public void chooseFieldAShouldExit() throws IOException {
//
//        InputStream sysInBackup = System.in;
//        ByteArrayInputStream in = new ByteArrayInputStream("ABC\n0\n".getBytes());
//        System.setIn(in);
//
//        Change changeMock = Mockito.mock(Change.class);
//
//        System.setIn(sysInBackup);
//    }

    @Test
    public void testInfoCheckValidInput() throws IOException, FileNotFoundException {
        // Set up
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String[] fields = {"First Name", "Last Name", "Age", "Phone", "Email", "Address", "Option 1", "Option 2", "Option 3"};
        ByteArrayInputStream in = new ByteArrayInputStream("NewName\nNewLastName\n30\n987654\nnew@example.com\nNewAddress\n2\nNewCity\n2000\n".getBytes());
        System.setIn(in);

        // Execute
        info_check(line, fields);

    }

    @Test
    public void testInfoCheckInvalidNumericInputShouldThrowNoSuchElementException() throws IOException, FileNotFoundException {
        // Given
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String[] fields = {"First Name", "Last Name", "Age", "Phone", "Email", "Address", "Option 1", "Option 2", "Option 3"};
        ByteArrayInputStream in = new ByteArrayInputStream("NewName\nNewLastName\nInvalidAge\n987654\nnew@example.com\nNewAddress\n2\nNewCity\n2000\n".getBytes());
        System.setIn(in);

        // Then
        assertThrows(NoSuchElementException.class, () -> {info_check(line, fields);});
    }

    @Test
    public void testInfoCheckMissingInformation() throws IOException, FileNotFoundException {
        // Given
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String[] fields = {"First Name", "Last Name", "Age", "Phone", "Email", "Address", "Option 1", "Option 2", "Option 3"};
        ByteArrayInputStream in = new ByteArrayInputStream("NewName\nNewLastName\n30\n987654\n\nNewAddress\n2\nNewCity\n2000\n".getBytes());
        System.setIn(in);

        // Then
        info_check(line, fields);
    }

    @Test
    public void testContactChangeSuccess() throws IOException, FileNotFoundException {
        // Set up
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String str = "NewName,NewLastName,30,987654,new@example.com,NewAddress,2,NewCity,2000";
        File contactsFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contacts.txt");
        File tempFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contactstemp.txt");
        // Copy the contacts file to a temporary file for testing
        Files.copy(contactsFile.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Execute
        contact_change(line, str);

        // Given
        String result = outputStream.toString().trim();

        // Then
        String expected = "Contact change is completed.";
        assertEquals(expected, result);

        // Clean up - delete the temporary file
        tempFile.delete();
    }

    @Test
    public void testContactChangeDuplicateMobileNumber() throws IOException, FileNotFoundException {
        // Set up
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String str = "NewName,NewLastName,21099999,142123,new@example.com,NewAddress,2,City,2000";
        File contactsFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contacts.txt");
        File tempFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contactstemp.txt");
        // Copy the contacts file to a temporary file for testing
        Files.copy(contactsFile.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Execute
        contact_change(line, str);

        // Given
        String result = outputStream.toString().trim();

        // Then
        String expected = "Mobile number must be unique among the contacts.";
        boolean check = expected.equals(result) ? true : false;
        assertTrue(check);

        // Clean up - delete the temporary file
        tempFile.delete();
    }

    @Test
    public void testContactChangeDuplicatePhoneNumber() throws IOException, FileNotFoundException {
        // Set up
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String str = "NewName,NewLastName,30,123456,new@example.com,NewAddress,2,City,2000";
        File contactsFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contacts.txt");
        File tempFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contactstemp.txt");
        // Copy the contacts file to a temporary file for testing
        Files.copy(contactsFile.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Execute
        contact_change(line, str);

        // Given
        String result = outputStream.toString().trim();

        // Then
        String expected = "Phone number must be unique among the contacts.";
        boolean check = expected.equals(result) ? true : false;
        assertTrue(check);

        // Clean up - delete the temporary file
        tempFile.delete();
    }

    @Test
    public void testContactChangeDuplicateEmail() throws IOException{
        // Set up
        String line = "John,Doe,25,123456,example@gmail.com,Address,1,City,1000";
        String str = "NewName,NewLastName,30,987654,pete@mail.com,NewAddress,2,City,2000";
        File contactsFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contacts.txt");
        File tempFile = new File(System.getProperty("user.dir")+"/src/main/java/org/example/contactstemp.txt");
        // Copy the contacts file to a temporary file for testing
        Files.copy(contactsFile.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Execute
        contact_change(line, str);

        // Given
        String result = outputStream.toString().trim();

        // Then
        String expected = "E-mail must be unique among the contacts.";
        boolean check = expected.equals(result) ? true : false;
        assertTrue(check);

        // Clean up - delete the temporary file
        tempFile.delete();
    }


}