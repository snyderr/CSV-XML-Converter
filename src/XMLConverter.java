import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ryan on 2/13/2018.
 */
public class XMLConverter {

    private String fileName;
    private Scanner input;
    private PrintWriter writer;
    boolean fileDoesNotExist = false;
    boolean incorrectFileType = false;


    public XMLConverter(String fileName){
        this.fileName = fileName;
        convert();
    }

    protected void convert(){
        System.out.println("Reading file...");
        readFile(fileName);
        if (!fileDoesNotExist && !incorrectFileType) {

            String columnHeaders[] = getColumnHeaders();
            writer = initializeXMLFile();

            while (input.hasNext()) {
                String currentRow[] = readNextRow();
                writeNextRow(columnHeaders, currentRow);
            }
            finishXMLFile();
            System.out.println("File has been converted to XML. " + fileName);
        }
    }

    public void readFile(String fileName){
        try {
            String extension = fileName.substring(fileName.lastIndexOf("."));
            if (!extension.equalsIgnoreCase(".csv")) {
                System.out.println("Incorrect file type. Must provide a file of type .csv");
                incorrectFileType = true;
            }
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("File does not have an extension.");
            incorrectFileType = true;
        }
        File originalFile = new File(fileName);
        try {
            input = new Scanner(originalFile);
        } catch (FileNotFoundException e) {
            System.out.println(fileName+" not found.");
            fileDoesNotExist = true;
        }
    }

    public String[] getColumnHeaders(){
        String columns = input.nextLine();
        String[] columnHeaders = columns.split(",", -1);
        return columnHeaders;
    }

    public String[] readNextRow(){
        String row = input.nextLine();
        String[] rowValues  = row.split(",", -1);
        return rowValues;
    }

    public void writeNextRow(String columnHeaders[], String rowValues[]){

        writer.println("    <row>");
        for (int i=0; i<columnHeaders.length;i++){
            writer.println("        <"+columnHeaders[i]+">"+rowValues[i]+"</"+columnHeaders[i]+">");
        }
        writer.println("    </row>");
    }

    public PrintWriter initializeXMLFile(){
        fileName = fileName.replace("csv", "xml");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException e) {
            System.exit(1);
        } catch (UnsupportedEncodingException e) {
            System.exit(1);
        }
        writer.println("<root>");
        return writer;
    }

    public void finishXMLFile(){
        writer.println("</root>");
        writer.close();
    }

    public String getFileName(){
        return fileName;
    }



}
