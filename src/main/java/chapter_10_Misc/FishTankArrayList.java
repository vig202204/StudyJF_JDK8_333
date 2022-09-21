package chapter_10_Misc;

import java.util.ArrayList;

public class FishTankArrayList {
    public static void main(String[] args) {
        ArrayList fishTank = new ArrayList(20);
        Fish theFish;
        Fish aFish = new Fish(20);
        aFish.setColor("червону");
        aFish.setWieght(2);
        fishTank.add(aFish);
        aFish = new Fish(10); // ??? як зробити поліморфізм для вікористання Fish(int) та Fish(String)
        aFish.setColor("зелену");
        aFish.setWieght(5);
        fishTank.add(aFish);
            // int fishCount = fishTank.size();
            //  for (int i = 0; i < fishCount; i++) {
        for (int i = 0; i < fishTank.size(); i++) {
             theFish = (Fish) fishTank.get(i);
            // String.format: System.out.printf("Впіймав %s рибу вагою %s кг. Глибина:%d%n",
            //                                  theFish.color, theFish.wieght, theFish.currentDepth);
            System.out.println("Впіймав " + theFish.getColor() + " рибу вагою " +
                    theFish.getWieght() + " кг. Глибина:" +
                    theFish.currentDepth);
        }
    }
}