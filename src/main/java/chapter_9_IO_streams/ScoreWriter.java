package chapter_9_IO_streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreWriter {
    public static void main(String[] args){
        FileWriter myFile = null;
        BufferedWriter buff = null;
        String[] scores = new String[3];

        //заповнення масиву результатами гри
        scores[0] = "Mr. Smith 240;";
        scores[1] = "Mr. Lee 300;";
        scores[2] = "Mr. Dolittle 190;";

        try {
            myFile = new FileWriter("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/scores2.txt");
            buff = new BufferedWriter(myFile);
            for (int i = 0; i < scores.length; i++) {
                //запис рядків з масіву у файл scores2.txt
                buff.write(scores[i]);
                System.out.println("Записується " + scores[i]);
            }
            System.out.println("Запис файлу завершено");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                buff.flush();
                buff.close();
                myFile.close();
            } catch(IOException e1) {
                e1.printStackTrace();
            }
        }
    } //end of main
}
