package chapter_10_Misc;
public class Pet {
    int age;
    float wieght;
    float height;
    String color;

    public void sleep() {
        System.out.println("Надобранич! До завтра");
    }

    public void eat() {
        System.out.println("Я дуже голодний, "
                + "давайте перекусимо чіпсами!");
    }

    public String say(String aWord) {
        String petResponse = "Ну гаразд!! " + aWord;
        return petResponse;
    }
}