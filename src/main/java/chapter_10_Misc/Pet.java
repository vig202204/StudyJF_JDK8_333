package chapter_10_Misc;
public class Pet {
    private int age;
    private float wieght;
    float height;
    private String color;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWieght() {
        return wieght;
    }

    public void setWieght(float wieght) {
        this.wieght = wieght;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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