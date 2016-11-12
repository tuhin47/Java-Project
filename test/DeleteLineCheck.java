
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DeleteLineCheck {

    private static void deleteLine() throws FileNotFoundException, IOException {
        File inputFile = new File("test\\File.txt");
        File tempFile = new File("test\\temp.txt");
        if (!inputFile.exists()) {
            inputFile.createNewFile();
        }
        
        
        
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        File a=inputFile,b=tempFile;

//        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
//
//        String lineToRemove = "bbb";
//        String currentLine;
//
//        while ((currentLine = reader.readLine()) != null) {
//            // trim newline when comparing with lineToRemove
//            String trimmedLine = currentLine.trim();
//            if (trimmedLine.equals(lineToRemove)) {
//                continue;
//            }
//            writer.write(currentLine + System.getProperty("line.separator"));
//        }
//        writer.close();
//        reader.close();
        boolean del = inputFile.delete();
        boolean successful = tempFile.renameTo(a);
        System.out.println("del"+del+" "+successful);
    }

    public static void main(String args[]) throws IOException {
        deleteLine();
        System.out.println("Done Deleting");
    }
}
