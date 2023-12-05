package common;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class SantasLittleHelper {

    public static BufferedReader getFileAsBufferedReader(String path) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reader;
    }
    public static List<String> getFileAsList(String path) throws IOException {
        try (BufferedReader reader = getFileAsBufferedReader(path)) {
            return reader.lines().toList();
        }
    }

}
