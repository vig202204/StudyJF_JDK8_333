package chapter_9_IO_streams;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteReader {
    public static void main(String[] args){
        FileInputStream myFile = null;
        int intValueOfByte = 0;
        try {
            //відкриття байтового потоку, що вказує на файл
            myFile = new FileInputStream("/Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/cornflower.png");

            while (true){
                intValueOfByte = myFile.read();
                System.out.print(" " + intValueOfByte);
                    if (intValueOfByte == -1) {
                        //досягнуто кінець файлу потрібно вийти з циклу
                        break;
                    }
            } //кінець циклу while
            //myFile.close(); не розміщуйте цей виклик тут
        } catch (IOException e) {
            System.out.println("Неможливо прочитати файл: " + e.toString());
        } finally {
            try{
                myFile.close();
            }catch (Exception e1){
                    e1.printStackTrace();
            }
            if (intValueOfByte == -1) {
                System.out.println(" ");
                System.out.println("Читання файлу завершено успішно");
            }else {
                System.out.println(" ");
                System.out.println("під час читання файлу виникли наступні проблеми:");
            }
        }
    }
}
