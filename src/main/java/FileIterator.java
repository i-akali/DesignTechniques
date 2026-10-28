import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class FileIterator implements Iterator<String> {

    private final Scanner scanner;

    public FileIterator(String f) {
        try {
            scanner = new Scanner(new File(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean hasNext() {
        return scanner.hasNextLine();
    }
    @Override
    public String next() {
        return scanner.nextLine();
    }

}
