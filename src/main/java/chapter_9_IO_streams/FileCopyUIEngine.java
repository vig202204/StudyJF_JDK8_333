package chapter_9_IO_streams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileCopyUIEngine extends Component implements ActionListener {
    FileCopyUI parent; //посилання на вікно калькулятора
    // String fSourse;

    //Конструктор зберігає посилання на вікно панелі
    //у змінній екземпляра класу
    FileCopyUIEngine(FileCopyUI parent) {
        this.parent = parent;
    }


    //@Override
    public void actionPerformed(ActionEvent e) {

        //Отримати джерело дії
        JButton clickedButton = (JButton) e.getSource();

        String dispFieldPathIN = parent.displaySource.getText();
        String dispFieldPathOUT = parent.displayDestination.getText();

        JFileChooser fChoose = new JFileChooser();
        Object src = e.getSource();



//Послідовно оброблюємо кнопки вибору файла для копіювання
        if (src == parent.buttonFrom) {
            int returnVal = fChoose.showOpenDialog(FileCopyUIEngine.this);
                System.out.println(returnVal);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileIN = fChoose.getSelectedFile();
                dispFieldPathIN = String.valueOf(fChoose.getSelectedFile());
                    System.out.println("dispFieldPathIn : " + dispFieldPathIN);
                parent.displaySource.setText(dispFieldPathIN);
            }
//Послідовно оброблюємо кнопки вибору каталогу для копіювання обраного файла
        } else if (src == parent.buttonTo) {
            fChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fChoose.showOpenDialog(FileCopyUIEngine.this);
                System.out.println(returnVal);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileOUT = fChoose.getSelectedFile();
                dispFieldPathOUT = String.valueOf(fChoose.getSelectedFile());
                parent.displayDestination.setText(dispFieldPathOUT);
                   System.out.println("dispFieldPathOUT : " + parent.displayDestination.getText());

            } else if (src == parent.buttonRunCopy) {
            // Виконання копіювання обраного файлу до destination-каталогу
            }
        }
    }
}
