package chapter_10_Misc;


public class Fish extends Pet {

    int currentDepth;

    public Fish(int i) {
       currentDepth = i;
    }

    public int dive(int howDeep) {
        int currentDepth = 0;
        currentDepth = currentDepth + howDeep;
        if (currentDepth > 100) {
            System.out.println("Занурююсь на глибину "
                    + howDeep + " футів");
            System.out.println("Я маленька рибка"
                    + " і не можу плаваті глибше 100 метрів");
            currentDepth = currentDepth - howDeep;
            System.out.println("Я на глибині "
                    + currentDepth + " футів нижче за"
                    + "рівень моря");
        }
        else
        {
            System.out.println("Занурююсь на глибину "
                    + howDeep + " футів");
            System.out.println("Я на глибині "
                    + currentDepth + " футів нижче за"
                    + "рівень моря");
        }
        return currentDepth;
    }

    public String say(String something) {
        return "Ти що, не знаєш, що риби не розмовляють?";
    }
}
