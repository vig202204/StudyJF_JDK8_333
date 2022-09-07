package chapter_9_IO_streams;

import java.io.*;



public class FileCopy {
    public static void main(String[] args) throws IOException {

        // FileReader in = null;
        FileInputStream in = null;
        // FileWriter out = null;
        FileOutputStream out = null;



        try {
            in = new FileInputStream("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333" +
                    "/src/main/java/chapter_9_IO_streams/cornflower.png");
            out = new FileOutputStream("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333" +
                    "/src/main/java/chapter_9_IO_streams/cornflower_copy.png");

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
