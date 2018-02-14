
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Created by Ryan on 2/14/2018.
 */
public class ConvertTest {

    /*
        Test if the program can properly convert a normal csv file to an xml file.
     */

    @Test
    public void testNormalFile() throws IOException {
        String fileName = "test-files\\normal-file.csv";
        XMLConverter normalFile = new XMLConverter(fileName);
        String correctContents = new String(Files.readAllBytes(Paths.get("test-files\\correct-files\\normal-file.xml")));
        String convertedContents = new String(Files.readAllBytes(Paths.get("test-files\\normal-file.xml")));
        assertEquals(correctContents,convertedContents);
    }

    /*
        Test if the program can properly convert a csv file that has missing data.
     */

    @Test
    public void testMissingFields() throws IOException {
        String fileName = "test-files\\missing-fields.csv";
        XMLConverter normalFile = new XMLConverter(fileName);
        String correctContents = new String(Files.readAllBytes(Paths.get("test-files\\correct-files\\missing-fields.xml")));
        String convertedContents = new String(Files.readAllBytes(Paths.get("test-files\\missing-fields.xml")));
        assertEquals(correctContents,convertedContents);
    }

    /*
        Test if the program can properly convert a large csv file.
     */

    @Test
    public void testLargeFile() throws IOException {
        String fileName = "test-files\\normal-file-large.csv";
        XMLConverter normalFile = new XMLConverter(fileName);
        String correctContents = new String(Files.readAllBytes(Paths.get("test-files\\correct-files\\normal-file-large.xml")));
        String convertedContents = new String(Files.readAllBytes(Paths.get("test-files\\normal-file-large.xml")));
        assertEquals(correctContents,convertedContents);
    }

    /*
        Ensure that a new xml file is not created when passing a fileName that does not exist.
     */

    @Test
    public void testInvalidFile() throws IOException{
        String fileName = "test-files\\does-not-exist";
        XMLConverter normalFile = new XMLConverter(fileName);
        File f = new File("test-files\\does-not-exist.xml");
        assertFalse(f.exists());

    }

    /*
        Ensure that a new xml file is not created when passing a file with no extension.
     */

    @Test
    public void testNoExtension() throws IOException{
        String fileName = "test-files\\no-extension";
        XMLConverter normalFile = new XMLConverter(fileName);
        File f = new File("test-files\\no-extension.xml");
        assertFalse(f.exists());

    }

        /*
        Ensure that a new xml file is not created when passing a file of the incorrect type.
     */

    @Test
    public void testWrongExtension() throws IOException{
        String fileName = "test-files\\incorrect-file-type.txt";
        XMLConverter normalFile = new XMLConverter(fileName);
        File f = new File("test-files\\incorrect-file-type.xml");
        assertFalse(f.exists());
    }
}
