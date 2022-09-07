package chapter_9_IO_streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteReader {
    public static void main(String[] args){
        FileInputStream myFile = null;
        BufferedInputStream buff = null;
        int intValueOfByte = 0;
        try {
            //відкриття байтового потоку, що вказує на файл
            myFile = new FileInputStream("Users/ihorvoloshyn/IdeaProjects/StudyJF_JDK8_333/src/main/java/chapter_9_IO_streams/cornflower.png");

            //з'єднуємо потоки FileInputStream та BufferedInputStream
            buff = new BufferedInputStream(myFile);
            while (true){
                intValueOfByte = buff.read();
                System.out.print(" " + intValueOfByte);
                    if (intValueOfByte == -1) {
                        //досягнуто кінець файлу потрібно вийти з циклу
                        System.out.println(" ");
                        System.out.print(" " + intValueOfByte);
                        break;
                    }
            } //кінець циклу while
            //myFile.close(); не розміщуйте цей виклик тут
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Неможливо прочитати файл: " + e.toString());
        } finally {
            try{
                buff.close();
                myFile.close();
            }catch (Exception e1){
                    e1.printStackTrace();
            }
//            if (intValueOfByte == -1) {
//                System.out.println(" ");
//                System.out.println("Читання файлу завершено успішно");
//            }else {
//                System.out.println(" ");
//                System.out.println("під час читання файлу виникли наступні проблеми:");
//            }
        }
    }
}
