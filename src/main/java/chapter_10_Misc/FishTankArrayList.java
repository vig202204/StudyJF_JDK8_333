package chapter_10_Misc;

import java.util.ArrayList;

public class FishTankArrayList {
    public static void main(String[] args) {
        ArrayList fishTank = new ArrayList(20);
        Fish theFish;
        Fish aFish = new Fish(20);
        aFish.color = "червону";
        aFish.wieght = 2;
        fishTank.add(aFish);
        aFish = new Fish("10"); // ??? як зробити поліморфізм для вікористання Fish(int) та Fish(String)
        aFish.color = "зелену";
        aFish.wieght = 5;
        fishTank.add(aFish);
        int fishCount = fishTank.size();
        for (int i = 0; i < fishCount; i++) {
            theFish = (Fish) fishTank.get(i);
            System.out.println("Впіймав "+ theFish.color + " рибу вагою " +
                                           theFish.wieght + " кг. Глибина:" +
                                           theFish. .currentDepth);


        }
    }
}
