package Chapter_7_TicTacToe;

/**
 * Гра хрестики-нулики
 * на дошці 3x3
 * */

// Практичні вправи:
// 1. Додайте на верхню панель класу TicTacToe два написи для підрахунку
// виграшів і програшів. Для цього оголосіть дві змінні в класі і збільшуйте від-
// повідну змінну щоразу, коли людина виграє або програє. Рахунок повинен
// оновлюватися відразу після того, як програма виводить повідомлення
// "You won" або "You lost".

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class TicTacToe extends Applet implements ActionListener{
    Button[] squares;
    Button newGameButton;
    Label score;
    Label scoreCountResult; //Практична вправа №1
    int scoreYourWins = 0;  //Практична вправа №1
    int scoreCompWins = 0;  //Практична вправа №1
    int emptySquaresLeft=9;

    /**
     * Метод init – це конструктор аплету
     * */

    public void init(){
//Встановлюємо менеджер розташування аплету, шрифт та колір
        this.setLayout(new BorderLayout());
        this.setBackground(Color.lightGray);
//Змінюємо шрифт аплету так, щоб він був жирним //і мав розмір 20
        Font appletFont=new Font("Monospased",Font.BOLD, 20);
        this.setFont(appletFont);

//Створюємо кнопку "Нова гра" і реєструємо в ній
//слухач дії
        newGameButton=new Button("New Game");
        newGameButton.addActionListener(this);


        Panel topPanel=new Panel();
        topPanel.setLayout(new GridLayout(2,2));
        topPanel.add(newGameButton);

        scoreCountResult = new Label("Yor score : " +
                                            scoreYourWins + " : " +
                                            scoreCompWins); //Практична вправа №1
        topPanel.add(scoreCountResult);
        this.add(topPanel,"North");

        Panel centerPanel=new Panel();
        centerPanel.setLayout(new GridLayout(3,3));
        this.add(centerPanel,"Center");

        score=new Label("Your turn!");
        this.add(score,"South");

//створюємо масив, щоб зберігати посилання на 9 кнопок
        squares=new Button[9];
//Створюємо кнопки, зберігаємо посилання на них в масиві
//реєструємо в них слухача, фарбуємо їх
//в помаранчевий колір і додаємо на панель
        for(int i=0;i<9;i++){
            squares[i]=new Button();
            squares[i].addActionListener(this);
            squares[i].setBackground(Color.ORANGE);
            centerPanel.add(squares[i]);
        }
    }
    /*
     * Цей метод буде обробляти всі події
     * @param ActionEvent об’єкт
     */
    public void actionPerformed(ActionEvent e) {
        Button theButton = (Button) e.getSource();

//Це кнопка New Game?
        if (theButton == newGameButton){
            for (int i=0;i<9;i++){
                squares[i].setEnabled(true);
                squares[i].setLabel("");
                squares[i].setBackground(Color.ORANGE);
            }
            emptySquaresLeft=9;

            scoreCountResult.setText("Yor score = " +
                                        scoreYourWins + " : " +
                                        scoreCompWins); //Практична вправа №1

            score.setText("Your turn!");
            newGameButton.setEnabled(false);
            return; //виходимо з методу
        }
        String winner = "";
//Це одна з клітинок?
        for (int i=0; i<9; i++) {

            if (theButton == squares[i]) {
                squares[i].setLabel("X");
                winner = lookForWinner();
                if (!"".equals(winner)) {
                    endTheGame();
                } else {
                    computerMove();
                    winner = lookForWinner();
                    if (!"".equals(winner)) {
                        endTheGame();
                    }
                }
                break;
            }
        } //кінець циклу for

        if (winner.equals("X")) {
            scoreYourWins ++; //Практична вправа №1
            score.setText("You won!");
            scoreCountResult.setText("Yor score = " +
                    scoreYourWins + " : " +
                    scoreCompWins);

        } else if (winner.equals("O")){
            scoreCompWins++; //Практична вправа №1
            score.setText("You lost!");
            scoreCountResult.setText("Yor score = " +
                    scoreYourWins + " : " +
                    scoreCompWins);

        } else if (winner.equals("T")){
            score.setText("It's a tie!"); }
    }
    //кінець методу actionPerformed
    /**
     * Цей метод викликається після кожного ходу, щоб дізнатись,
     * чи є переможець. Він перевіряє кожен ряд, колонку та
     * діагональ, щоб знайти три клітинки з однаковими написами
     * (не пустими) @return "X", "O", "T" – нічия, "" - ще немає переможця
     */
    String lookForWinner() {
        String theWinner = "";
        emptySquaresLeft--;
        if (emptySquaresLeft==0){
            return "T"; //це нічия. T від англійского слова tie
        }
//Перевіряємо ряд 1 – елементи масиву 0,1,2
        if (!squares[0].getLabel().equals("") &&
                squares[0].getLabel().equals(squares[1].getLabel()) &&
                squares[0].getLabel().equals(squares[2].getLabel())){
            theWinner = squares[0].getLabel();
            highlightWinner(0,1,2);
//Перевіряємо ряд 2 – елементи масиву 3,4,5
        } else if (!squares[3].getLabel().equals("") &&
                squares[3].getLabel().equals(squares[4].getLabel()) &&
                squares[3].getLabel().equals(squares[5].getLabel())) {
            theWinner = squares[3].getLabel();
            highlightWinner(3,4,5);
//Перевіряємо ряд 3 – елементи масиву 6,7,8
        } else if (! squares[6].getLabel().equals("") &&
                squares[6].getLabel().equals(squares[7].getLabel()) &&
                squares[6].getLabel().equals(squares[8].getLabel())) {
            theWinner = squares[6].getLabel();
            highlightWinner(6,7,8);
//Перевіряємо колонку 1 – елементи масиву 0,3,6
        } else if (! squares[0].getLabel().equals("") &&
                squares[0].getLabel().equals(squares[3].getLabel()) &&
                squares[0].getLabel().equals(squares[6].getLabel())) {
            theWinner = squares[0].getLabel();
            highlightWinner(0,3,6);
//Перевіряємо колонку 2 – елементи масиву 1,4,7
        } else if (! squares[1].getLabel().equals("") &&
                squares[1].getLabel().equals(squares[4].getLabel()) &&
                squares[1].getLabel().equals(squares[7].getLabel())) {
            theWinner = squares[1].getLabel();
            highlightWinner(1,4,7);
//Перевіряємо колонку 3 – елементи масиву 2,5,8
        } else if (! squares[2].getLabel().equals("") &&
                squares[2].getLabel().equals(squares[5].getLabel()) &&
                squares[2].getLabel().equals(squares[8].getLabel())) {
            theWinner = squares[2].getLabel();
            highlightWinner(2,5,8);
//Перевіряємо першу діагональ – елементи масиву 0,4,8
        } else if ( ! squares[0].getLabel().equals("") &&
                squares[0].getLabel().equals(squares[4].getLabel()) &&
                squares[0].getLabel().equals(squares[8].getLabel())) {
            theWinner = squares[0].getLabel();
            highlightWinner(0,4,8);
//Перевіряємо другу діагональ – елементи масиву 2,4,6
        } else if ( ! squares[2].getLabel().equals("") &&
                squares[2].getLabel().equals(squares[4].getLabel()) &&
                squares[2].getLabel().equals(squares[6].getLabel())) {
            theWinner = squares[2].getLabel();
            highlightWinner(2,4,6);
        }
        return theWinner;
    }
    /**
     * Цей метод застосовує набір правил, щоб знайти
     * кращий комп’ютерний хід. Якщо гарний хід
     * не знайдено, вибирається випадкова клітинка.
     */
    void computerMove() { int selectedSquare;

//Спочатку комп'ютер намагається знайти порожню клітинку
//поряд з двома клітинками з нуликами, щоб виграти
        selectedSquare = findEmptySquare("O");
//Якщо він не може знайти два нулика, то хоча б
//спробує не дати опонентові зробити ряд з 3-х
//хрестиків, помістивши нулик поряд з двома хрестиками
        if (selectedSquare == -1){
            selectedSquare = findEmptySquare("X");
        }
//якщо selectedSquare все ще дорівнює -1, то
//спробує зайняти центральну клітинку
        if ((selectedSquare == -1) &&
                (squares[4].getLabel().equals(""))){
            selectedSquare=4; }
//не пощастило з центральною клітинкою ...
//просто займаємо випадкову клітинку
        if (selectedSquare == -1){
            selectedSquare = getRandomSquare();
        }
        squares[selectedSquare].setLabel("O");
    }


    /*
     * Цей метод перевіряє кожен ряд, колонку і діагональ
     * щоб дізнатися, чи є в ній дві клітинки
     * З однаковими написами і порожньою клітинкою.
     * @param передається X - для користувача і O - для компа
     * @return кількість вільних клітинок,
     *         або -1, якщо не знайдено дві клітинки
     *         з однаковими написами
     */

    int findEmptySquare(String player) {

        int[] weight = new int[9];

        for (int i = 0; i < 9; i++ ) {
            if ( squares[i].getLabel().equals("O") )
                weight[i] = -1;
            else if (squares[i].getLabel().equals("X") )
                weight[i] = 1;
            else
                weight[i] = 0;
        }
        int twoWeights = player.equals("O") ? -2 : 2;

//Перевіримо, чи є в ряду 1 дві однакові клітинки і
//одна порожня.
        if (weight[0] + weight[1] + weight[2] == twoWeights) {

            if (weight[0] == 0)
                return 0;
            else if (weight[1] == 0)
                return 1;
            else
                return 2;
        }
//Перевіримо, чи є в ряду 2 дві однакові клітинки і
//одна порожня.
        if (weight[3] + weight[4] + weight[5] == twoWeights) {
            if (weight[3] == 0)
                return 3;
            else if (weight[4] == 0)
                return 4;
            else
                return 5;
        }
//Перевіримо, чи є в ряду 3 дві однакові клітинки і
//одна порожня.
        if (weight[6] + weight[7] + weight[8] == twoWeights) {
            if (weight[6] == 0)
                return 6;
            else if (weight[7] == 0)
                return 7;
            else
                return 8;
        }
//Перевіримо, чи є в колонці 1 дві однакові клітинки і
//одна порожня.
        if (weight[0] + weight[3] + weight[6] == twoWeights) {
            if (weight[0] == 0)
                return 0;
            else if (weight[3] == 0)
                return 3;
            else
                return 6;
        }
//Перевіримо, чи є в колонці 2 дві однакові клітинки і //одна порожня.
        if (weight[1] + weight[4] + weight[7] == twoWeights) {
            if (weight[1] == 0)
                return 1;
            else if (weight[4] == 0)
                return 4;
            else
                return 7; }
//Перевіримо, чи є в колонці 3 дві однакові клітинки і
//одна порожня.
        if (weight[2] + weight[5] + weight[8] == twoWeights ){
            if ( weight[2] == 0 )
                return 2;
            else if ( weight[5] == 0 )
                return 5;
            else
                return 8;
        }
//Перевіримо, чи є в діагоналі 1 дві однакові клітинки і
//одна порожня.
        if (weight[0] + weight[4] + weight[8] == twoWeights ){
            if ( weight[0] == 0 )
                return 0;
            else if ( weight[4] == 0 )
                return 4;
            else
                return 8;
        }
//Перевіримо, чи є в діагоналі 2 дві однакові клітинки і
//одна порожня.
        if (weight[2] + weight[4] + weight[6] == twoWeights ){
            if ( weight[2] == 0 )
                return 2;
            else if ( weight[4] == 0 )
                return 4;
            else
                return 6;
        }
//Не знайдено двох однакових сусідніх клітинок
        return -1;
    } //кінець методу findEmptySquare()

    /**
     * Цей метод вибирає будь-яку пусту клітинку
     * @return випадково вибраний номер клітинки
     */
    int getRandomSquare() {
        boolean gotEmptySquare = false;
        int selectedSquare = -1;
        do {
            selectedSquare = (int) (Math.random() * 9 );
            if (squares[selectedSquare].getLabel().equals("")) {
                gotEmptySquare = true; //щоб закінчити цикл
            }
        } while (!gotEmptySquare );
        return selectedSquare;
    } //кінець методу getRandomSquare()

    /*
     * Цей метод виділяє виграшну лінію.
     * @param преша, друга і третя клітинки для виділення
     * */
    void highlightWinner(int win1, int win2, int win3) {
        squares[win1].setBackground(Color.lightGray);
        squares[win2].setBackground(Color.lightGray);
        squares[win3].setBackground(Color.lightGray);
    }
    //Робимо недоступними клітинки та доступною
//кнопку ”New Game”
    void endTheGame(){
        newGameButton.setEnabled(true);
        for (int i=0; i<9; i++){
            squares[i].setEnabled(false);
        }
    }
} //кінець класу} //кінець класу