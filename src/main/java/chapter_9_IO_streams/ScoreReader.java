package chapter_9_IO_streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreReader {
    public static void main(String[] args){

        FileReader myFile = null;
        BufferedReader buff = null;

        try {
            myFile = new FileReader("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/scores2.txt");
            buff = new BufferedReader(myFile);
            while (true) {
                //зчитується рядок з файлу scores.txt
                String line = buff.readLine();

                //перевірка досягнення кинця файлу
                if (line == null) break;
                    System.out.println(line);
            }//кінець ціклу while
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                buff.close();
                myFile.close();
            }catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    } //кинець методу main
}
