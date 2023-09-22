package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<NonogramNumber> verticalNumbers;
    static List<NonogramNumber> horizontalNumbers;

    public static void main(String[] args) {
//        NonogramNumber vertical2 = new NonogramNumber();
//        vertical2.add(1);
//        vertical2.add(1);
//        vertical2.add(2);
//        List<Integer> scoreList = NonogramAlgorithms.getScoreList(vertical2, 6);
//        scoreList.forEach(System.out::println);
        initMap2();
        NonogramMatrix matrix = new NonogramMatrix(verticalNumbers, horizontalNumbers);
        System.out.println(matrix);
    }

    private static void initMap2() {
        NonogramNumber vertical1 = new NonogramNumber();
        vertical1.add(2);
        vertical1.add(3);
        NonogramNumber vertical2 = new NonogramNumber();
        vertical2.add(1);
        vertical2.add(5);
        NonogramNumber vertical3 = new NonogramNumber();
        vertical3.add(2);
        vertical3.add(3);
        NonogramNumber vertical4 = new NonogramNumber();
        vertical4.add(1);
        vertical4.add(3);
        NonogramNumber vertical5 = new NonogramNumber();
        vertical5.add(1);
        vertical5.add(1);
        vertical5.add(2);
        NonogramNumber vertical6 = new NonogramNumber();
        vertical6.add(1);
        vertical6.add(1);
        vertical6.add(4);
        NonogramNumber vertical7 = new NonogramNumber();
        vertical7.add(2);
        vertical7.add(3);
        vertical7.add(2);
        NonogramNumber vertical8 = new NonogramNumber();
        vertical8.add(1);
        vertical8.add(2);
        vertical8.add(1);
        NonogramNumber vertical9 = new NonogramNumber();
        vertical9.add(4);
        vertical9.add(2);
        NonogramNumber vertical10 = new NonogramNumber();
        vertical10.add(3);

        verticalNumbers = new ArrayList<>();
        verticalNumbers.add(vertical1);
        verticalNumbers.add(vertical2);
        verticalNumbers.add(vertical3);
        verticalNumbers.add(vertical4);
        verticalNumbers.add(vertical5);
        verticalNumbers.add(vertical6);
        verticalNumbers.add(vertical7);
        verticalNumbers.add(vertical8);
        verticalNumbers.add(vertical9);
        verticalNumbers.add(vertical10);

        NonogramNumber horizontal1 = new NonogramNumber();
        horizontal1.add(2);
        horizontal1.add(3);
        NonogramNumber horizontal2 = new NonogramNumber();
        horizontal2.add(1);
        horizontal2.add(1);
        horizontal2.add(1);
        NonogramNumber horizontal3 = new NonogramNumber();
        horizontal3.add(2);
        horizontal3.add(3);
        NonogramNumber horizontal4 = new NonogramNumber();
        horizontal4.add(2);
        horizontal4.add(1);
        horizontal4.add(1);
        NonogramNumber horizontal5 = new NonogramNumber();
        horizontal5.add(2);
        horizontal5.add(3);
        NonogramNumber horizontal6 = new NonogramNumber();
        horizontal6.add(3);
        horizontal6.add(4);
        NonogramNumber horizontal7 = new NonogramNumber();
        horizontal7.add(3);
        horizontal7.add(2);
        horizontal7.add(2);
        NonogramNumber horizontal8 = new NonogramNumber();
        horizontal8.add(4);
        horizontal8.add(1);
        NonogramNumber horizontal9 = new NonogramNumber();
        horizontal9.add(4);
        horizontal9.add(2);
        NonogramNumber horizontal10 = new NonogramNumber();
        horizontal10.add(3);

        horizontalNumbers = new ArrayList<>();
        horizontalNumbers.add(horizontal1);
        horizontalNumbers.add(horizontal2);
        horizontalNumbers.add(horizontal3);
        horizontalNumbers.add(horizontal4);
        horizontalNumbers.add(horizontal5);
        horizontalNumbers.add(horizontal6);
        horizontalNumbers.add(horizontal7);
        horizontalNumbers.add(horizontal8);
        horizontalNumbers.add(horizontal9);
        horizontalNumbers.add(horizontal10);
    }

    private static void initMap1() {
        verticalNumbers = new ArrayList<>();
        NonogramNumber vertical1 = new NonogramNumber();
        vertical1.add(0);
        NonogramNumber vertical2 = new NonogramNumber();
        vertical2.add(2);
        NonogramNumber vertical3 = new NonogramNumber();
        vertical3.add(2);
        NonogramNumber vertical4 = new NonogramNumber();
        vertical4.add(2);
        NonogramNumber vertical5 = new NonogramNumber();
        vertical5.add(0);
        verticalNumbers.add(vertical1);
        verticalNumbers.add(vertical2);
        verticalNumbers.add(vertical3);
        verticalNumbers.add(vertical4);
        verticalNumbers.add(vertical5);

        horizontalNumbers = new ArrayList<>();
        NonogramNumber horizontal1 = new NonogramNumber();
        horizontal1.add(0);
        NonogramNumber horizontal2 = new NonogramNumber();
        horizontal2.add(1);
        horizontal2.add(1);
        NonogramNumber horizontal3 = new NonogramNumber();
        horizontal3.add(3);
        NonogramNumber horizontal4 = new NonogramNumber();
        horizontal4.add(1);
        NonogramNumber horizontal5 = new NonogramNumber();
        horizontal5.add(0);
        NonogramNumber horizontal6 = new NonogramNumber();
        horizontal6.add(0);
        horizontalNumbers.add(horizontal1);
        horizontalNumbers.add(horizontal2);
        horizontalNumbers.add(horizontal3);
        horizontalNumbers.add(horizontal4);
        horizontalNumbers.add(horizontal5);
    }
}