package chapter_9_IO_streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333" +
                    "/src/main/java/chapter_9_IO_streams/scores.txt");
            out = new FileWriter("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333" +
                    "/src/main/java/chapter_9_IO_streams/scores_copy.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in  != null) in.close();
            if (out != null) out.close();
        }
    }
}
