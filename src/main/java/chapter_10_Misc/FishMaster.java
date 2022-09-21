package chapter_10_Misc;

public class FishMaster {

    public static void main(String[] args) {

        Fish myFish = new Fish(10);
        // Pet myPet = new Pet();

        // Спробуємо змусити нашу рибу зануритисяніжче 100 метрів
        myFish.dive(2);
        myFish.dive(97);
        myFish.dive(3);

        myFish.say("Привіт");
        String sayFish = myFish.say("Привіт");
        // String sayPety = myPet.say("Привіт");
        System.out.println(sayFish);
        myFish.sleep();

    }

}

