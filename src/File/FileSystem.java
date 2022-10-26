package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSystem {
    public static String cache = "";
    public void appStr(String str){
        cache = cache.concat(str);
    }

    public void writeInFile() throws IOException {
        String fileName = "FightInfo.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(cache);
        writer.close();
    }
}
