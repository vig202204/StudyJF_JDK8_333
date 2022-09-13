package chapter_9_IO_streams;

import javax.swing.*;
import java.awt.*;

/* * *
* Практичні вправи для розумників і розумниць
* Створіть Swing-додаток, що дозволяє користувачам вибирати імена файлів для копіювання,
* використовуючи клас JFileChooser, який створює стандартне вікно вибору файлу. Це вікно має
* відкриватися при натисканні користувачем однієї з кнопок Browse. Потрібно буде додати кілька
* рядків коду для відображення обраного імені файлу в текстовому полі.
* Після того, як користувач натискає кнопку Copy, код в методі actionPerformed () повинен скопіювати
* вибраний файл.
* Спробуйте заново використовувати код з попередніх завдань, але без прямого копіювання / вставки.
*   Виконання вправи:
*   План побудови застосунку:
*       1. Написання swing-інтерфейсу для копиювання файлу без можливості його перейменування.
*           1.1. Поле "JTextField displaySource" та "JTextField displayDestination" - ReadOnly.
*       2. Написання слухача подій:
*           2.1. Використовуємо JFileChooser() задля побудови діалогу з вибору source-файлу для
*                подальшого копіювання;
*           2.2. Пошук destination-каталогу починається з поточного каталогу обраного source-файланазва;
*           2.3. У полі "Copy to:" видображується тилькі destination-каталог за використання JFileChooser.DIRECTORIES_ONLY;
*           2.4. Написання методу actionPerformed().
*           2.5. Нааписання коду по завершенню роботи застосунку.
* * */
public class FileCopyUI {
    JPanel windowContent = new JPanel();

    JButton buttonFrom = new JButton("Browse");
    JButton buttonTo = new JButton("Browse");
    JButton buttonRunCopy = new JButton("Copy");

    JTextField displaySource = new JTextField("");

    JTextField displayDestination = new JTextField("");

    JLabel lbCopyFrom = new JLabel(" Copy from:");
    JLabel lbCopyTo = new JLabel(" Copy to:");

    // Створюємо конструктор
    FileCopyUI(){
        displaySource.setEnabled(false);
        displayDestination.setEnabled(false);

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

        //Створюємо екземпляр слухача подій і
        //Реєструємо його в кожній кнопці
        FileCopyUIEngine copyUIEngine = new FileCopyUIEngine(this);
        buttonFrom.addActionListener(copyUIEngine);
        buttonTo.addActionListener(copyUIEngine);

        // Закінчення роботи застосунку
        windowClosing();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void windowClosing() {
    }

    public static void main(String[] args) {

        //Створюємо екземпляр класу "Калькулятор"
        FileCopyUI filecopy = new FileCopyUI();
    }
}
