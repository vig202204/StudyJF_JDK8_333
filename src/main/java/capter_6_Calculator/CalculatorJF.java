package capter_6_Calculator;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.WindowListener;

public class CalculatorJF {

    //Оголошуємо та ініціалізуємо компоненти вікна
    JButton button0=new JButton("0");
    JButton button1=new JButton("1");
    JButton button2=new JButton("2");
    JButton button3=new JButton("3");
    JButton button4=new JButton("4");
    JButton button5=new JButton("5");
    JButton button6=new JButton("6");
    JButton button7=new JButton("7");
    JButton button8=new JButton("8");
    JButton button9=new JButton("9");

    JButton buttonPoint=new JButton(".");
    JButton buttonEqual=new JButton("=");
    JButton buttonPlus=new JButton("+");
    JButton buttonMinus=new JButton("-");
    JButton buttonDivide=new JButton("/");
    JButton buttonMultiply=new JButton("*");

    JPanel windowContent=new JPanel();
    JTextField displayField=new JTextField(30);

    // Конструктор
    CalculatorJF(){

        //Встановити менеджер розташування для панелі
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout (bl);

        //Додаємо дисплей у верхній частині вікна
        windowContent.add("North", displayField);

        //Створюємо панель з менеджером розташування
        //GridLayout в якій буде 12 кнопок - 10 цифр, та
        //кнопки "крапка" і "дорівнює"
        JPanel p1 = new JPanel();
        GridLayout gl = new GridLayout(4,3);
        p1.setLayout(gl);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);

        //Додаємо панель p1 в центр вікна
        windowContent.add("Center",p1);

        //Створюємо панель з менеджером розташування
        //GridLayout на якій буде 4 кнопки -
        //Плюс, Мінус, Розділити та Помножити
        JPanel p2 = new JPanel();
        GridLayout gl2 = new GridLayout(4,1);
        p2.setLayout(gl2);
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivide);

        //Додаємо панель p2 в праву частину вікна
        windowContent.add("East",p2);

        //Створюємо frame і додаємо в нього вміст
        JFrame frame = new JFrame ("Calculator");
        frame.setContentPane(windowContent);

        //Встановлюємо розмір вікна, так щоб вмістилися
        //Всі компоненти
        frame.pack();

        //Показуємо вікно
        frame.setVisible (true);


        //Створюємо екземпляр слухача подій і
        //Реєструємо його в кожній кнопці
        CalculatorEngineJF calcEngineJF = new CalculatorEngineJF(this);
        button0.addActionListener(calcEngineJF);
        button1.addActionListener(calcEngineJF);
        button2.addActionListener(calcEngineJF);
        button3.addActionListener(calcEngineJF);
        button4.addActionListener(calcEngineJF);
        button5.addActionListener(calcEngineJF);
        button6.addActionListener(calcEngineJF);
        button7.addActionListener(calcEngineJF);
        button8.addActionListener(calcEngineJF);
        button9.addActionListener(calcEngineJF);
        buttonPoint.addActionListener(calcEngineJF);
        buttonPlus.addActionListener(calcEngineJF);
        buttonMinus.addActionListener(calcEngineJF);
        buttonDivide.addActionListener(calcEngineJF);
        buttonMultiply.addActionListener(calcEngineJF);
        buttonEqual.addActionListener(calcEngineJF);
        windowClosing();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void windowClosing() {
    }

    public static void main(String[] args) {

        //Створюємо екземпляр класу "Калькулятор"
        CalculatorJF calc = new CalculatorJF();
    }
}