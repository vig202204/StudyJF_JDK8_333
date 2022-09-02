package capter_6_Calculator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class CalculatorEngineJF implements ActionListener{

    CalculatorJF parent; //посилання на вікно калькулятора

    char selectedAction = ' '; // +, -, /, або *
    double currentResult = 0;

    //для контроля подвійної крапки
    int countDoublePoint =0;

    //Конструктор зберігає посилання на вікно калькулятора
// у змінній екземпляра класу
    CalculatorEngineJF (CalculatorJF parent) {
        this.parent = parent;
    }

    public void actionPerformed (ActionEvent e){

        //Отримати джерело дії
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = parent.displayField.getText();
        double displayValue = 0;

//Отримати число з дисплея калькулятора,
// якщо він не порожній.
//Знак оклику - це оператор заперечення
        if (!"".equals(dispFieldText)) {
            // (Я.Ф. стор. 156). Додавання обробки виключення
            // для нецифрового вводу у поле калькулятора
            try {
                displayValue = Double.parseDouble(dispFieldText);
            } catch (NumberFormatException ex) {
//                Заміна на UserFriendly повідомлення
//                throw new RuntimeException(ex);
                javax.swing.JOptionPane.showConfirmDialog(null,
                        "Будь ласка, введіть чісло",
                        "Неправильне введення",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            } finally {
                parent.displayField.setText ("");
            }
        }
        Object src = e.getSource();

//Для кожної кнопки арифметичної дії
//запам'ятати її:+,-,/, або *, зберегти поточне число
//у змінній currentResult, і очистити дисплей
//для введення нового числа
        if (src == parent.buttonPlus) {
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText ("");
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            currentResult = displayValue;
            parent.displayField.setText ("");
        } else if (src == parent.buttonDivide) {
            selectedAction = '/';
            currentResult = displayValue;
            /*
            Практичні вправи:
            Спробуйте розділити число на нуль за допомогою на-
            шого калькулятора - дисплей покаже слово Infinity.
            Змініть клас CalculatorEngine, щоб відображалося по-
            відомлення "На нуль ділити не можна", якщо кори-
            стувач натисне на кнопку "Розділити", коли дисплей калькулятора буде порожній.
             */
            if (displayValue == 0.0){
                parent.displayField.setText ("На нуль ділити не можна");
            } else
                parent.displayField.setText ("");
        } else if (src == parent.buttonMultiply) {
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText ("");
        } else if (src == parent.buttonEqual) {
            // listFromDisplay.clear();             // vig
            //Здійснити арифметичну дію, залежно
            //від selectedAction, оновити змінну currentResult
            //і показати результат на дисплеї
            if (selectedAction == '+') {
                currentResult += displayValue;
                //Конвертувати результат в рядок, додаючи його
                // до порожнього рядку і показати його
                parent.displayField.setText(""+currentResult);
            } else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.displayField.setText(""+currentResult);
            } else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.displayField.setText(""+currentResult);
            } else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.displayField.setText(""+currentResult);
            }
        } else {

            //Для всіх цифрових кнопок приєднати напис на
            //кнопці до напису в дисплеї
            String clickedButtonLabel = clickedButton.getText();

          /*  Практичні вправи для розумників і розумниць:
             Змініть клас CalculatorEngine, щоб заборонити вводити
             більше однієї крапки в числі.
              Підказка: прочитайте про метод indexOf() класу String,
              щоб дізнатися, чи є вже в числі крапка.*/

            String predispFieldText = dispFieldText +
                    clickedButtonLabel;
            // Якщо крапки немає
            if (predispFieldText.indexOf(".") == -1) {
                parent.displayField.setText(dispFieldText + clickedButtonLabel);
                String rezultdispFieldText = predispFieldText;
            } else {
                // Якщо є крапка
                if (countDoublePoint == 0) {
                    // и вон перша, то додаємо до строки калькулятора
                    parent.displayField.setText(dispFieldText + clickedButtonLabel);
                    countDoublePoint++;
                } else if (countDoublePoint >= 1) {
                    // а якщо крапка не перша, то відкидаємо її
                    // і залишаємо строку вводу калькулятора без змін
                    if (clickedButtonLabel == ".") {
                        System.out.println("Exeption of Double Point = " + countDoublePoint);
                        parent.displayField.setText(dispFieldText);
                    } else {
                        parent.displayField.setText(dispFieldText + clickedButtonLabel);
                        System.out.println(dispFieldText + clickedButtonLabel);
                    }
                }
            }
        }
    }
}