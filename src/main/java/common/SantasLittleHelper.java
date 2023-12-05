package common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

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

}
