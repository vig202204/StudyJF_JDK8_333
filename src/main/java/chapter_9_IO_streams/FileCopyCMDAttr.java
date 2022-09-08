package chapter_9_IO_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;


public class FileCopyCMDAttr {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        int c;
        if (args.length !=2) {
            System.out.println("Будь ласка, зазначте назви файлів, наприклад:");
            System.out.println("java FileCopyCMDAttr.java 'NameSource_File' 'NameDestinationFile'");
            // Вихід з програми
            System.exit(0);
        }else try {
            // Let’s begin with the standard solution using System#getProperty,
            // assuming our current working directory from Baeldung throughout the code (works on all JDK version):
            String userDirectory_BaelDung_1 = System.getProperty("user.dir");
                System.out.println("Current Path : " + userDirectory_BaelDung_1);
            // Let's see another solution using java.io.File from Baeldung to get our
            // current working directory name (works on all JDK version):
            String userDirectory_BaelDung_2 = new File("").getAbsolutePath();
            System.out.println(userDirectory_BaelDung_2);
                System.out.println("Args1 : " + args[0]);
                System.out.println("Args2 : " + args[1]);
            in = new FileInputStream(userDirectory_BaelDung_1 + "/" + args[0]);
            //                          in = new FileInputStream("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333"/src/main/java/chapter_9_IO_streams/cornflower.png");
            out = new FileOutputStream(userDirectory_BaelDung_1 + "/" + args[1]);
            //                          out = new FileOutputStream("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/cornflower_copy.png");
                System.out.println("First param : " + in);
                System.out.println("Second param : " + out);
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}