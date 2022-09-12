package chapter_9_IO_streams;

import capter_6_Calculator.CalculatorJF;

import javax.swing.*;
import java.awt.*;

/*
* Практичні вправи для розумників і розумниць
* Створіть Swing-додаток, що дозволяє користувачам вибирати імена файлів для копіювання,
* використовуючи клас JFileChooser, який створює стандартне вікно вибору файлу. Це вікно має
* відкриватися при натисканні користувачем однієї з кнопок Browse. Потрібно буде додати кілька
* рядків коду для відображення обраного імені файлу в текстовому полі.
* Після того, як користувач натискає кнопку Copy, код в методі actionPerformed () повинен скопіювати
* вибраний файл.
* Спробуйте заново використовувати код з попередніх завдань, але без прямого копіювання / вставки.
* */
public class FileCopyUI {
    JPanel windowContent = new JPanel();

    JButton buttonFrom = new JButton("Browse");
    JButton buttonTo = new JButton("Browse");
    JButton buttonRunCopy = new JButton("Copy");

    JTextField displaySource = new JTextField();
    JTextField displayDestination = new JTextField();

    JLabel lbCopyFrom = new JLabel(" Copy from:");
    JLabel lbCopyTo = new JLabel(" Copy to:");

    // Створюємо конструктор
    FileCopyUI(){

        // Встановлюємо менеджер розташування панелі
        BorderLayout borderLayout = new BorderLayout();
        windowContent.setLayout(borderLayout);

        //Створюємо панель з менеджером розташування
        JPanel p1 = new JPanel();
        GridLayout gl1 = new GridLayout(3,1);
        p1.setLayout(gl1);
        p1.add(lbCopyFrom);
        p1.add(lbCopyTo);


        JPanel p2 = new JPanel();
        GridLayout gl2 = new GridLayout(3,1);
        p2.setLayout(gl2);
        p2.add(displaySource);
        p2.add(displayDestination);
        p2.add(buttonRunCopy);

        JPanel p3 = new JPanel();
        GridLayout gl3 = new GridLayout(3,1);
        p3.setLayout(gl3);
        p3.add(buttonFrom);
        p3.add(buttonTo);

        //Додаємо панель p1 в центр вікна
        windowContent.add("West",p1);
        windowContent.add("Center", p2);
        windowContent.add("East", p3);

        //Створюємо frame і додаємо в нього вміст
        JFrame frame = new JFrame ("File Copy");
        frame.setContentPane(windowContent);

        //Встановлюємо розмір вікна, так щоб вмістилися
        //Всі компоненти
        frame.pack();

        //Показуємо вікно
        frame.setVisible (true);
    }
    private void windowClosing() {
    }

    public static void main(String[] args) {

        //Створюємо екземпляр класу "Калькулятор"
        FileCopyUI filecopy = new FileCopyUI();
    }

}
