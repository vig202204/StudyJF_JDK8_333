package chapter_9_IO_streams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileCopyUIEngine extends Component implements ActionListener {
    FileCopyUI parent; //посилання на вікно калькулятора

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
        String dispFileNameOUTPrim = parent.displayDestinationPrim.getText();

        String dispFileNameIN = "";
        String dispFileNameOUT = "";

        JFileChooser fChoose = new JFileChooser();
        Object src = e.getSource();

//Послідовно оброблюємо кнопки вибору файла для копіювання
        if (src == parent.buttonFrom) {
            int returnVal = fChoose.showOpenDialog(FileCopyUIEngine.this);
            System.out.println(returnVal);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileIN = fChoose.getSelectedFile();
                dispFieldPathIN = String.valueOf(fChoose.getSelectedFile());
                dispFileNameIN = fileIN.getName();
                parent.displaySource.setText(dispFieldPathIN);
                parent.displayDestinationPrim.setText("/" + dispFileNameIN);
            }
//Послідовно оброблюємо кнопки вибору каталогу для копіювання обраного файла
        } else if (src == parent.buttonTo) {
            fChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnVal = fChoose.showOpenDialog(FileCopyUIEngine.this);
            System.out.println(returnVal);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File fileOUT = fChoose.getSelectedFile();
                dispFieldPathOUT = String.valueOf(fChoose.getSelectedFile());
                // dispFileNameIN = "";
                // dispFileNameOUT = dispFieldPathOUT + "/" + dispFileNameIN;
                parent.displayDestination.setText(dispFieldPathOUT + dispFileNameOUTPrim);
                System.out.println("dispFileNameOUT : " + dispFileNameOUTPrim);
            }
//Послідовно оброблюємо кнопки виконання копіювання обраного файла
        } else if (src == parent.buttonRunCopy) {
            // Виконання копіювання обраного файлу до destination-каталогу
            try {
                actionPerformed(dispFieldPathIN, dispFieldPathOUT);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public void actionPerformed (String inp, String outp) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        int c;
        try {
                in = new FileInputStream(inp);
                out = new FileOutputStream(outp);
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (in  != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
