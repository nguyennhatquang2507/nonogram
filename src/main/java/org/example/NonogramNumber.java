package org.example;

import java.util.ArrayList;
import java.util.List;

public class NonogramNumber {

    private List<Integer> numbers;

    private int totalPoint;

    private int minimumSpaceQuantity;

    public NonogramNumber() {
        numbers = new ArrayList<>();
        minimumSpaceQuantity = 0;
        totalPoint = 0;
    }

    public void add(int number) {
        this.numbers.add(number);
        minimumSpaceQuantity += (minimumSpaceQuantity == 0) ? number : number + 1;
        totalPoint += number;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public int getMinimumSpaceQuantity() {
        return minimumSpaceQuantity;
    }

    public NonogramNumber child() {
        NonogramNumber nonogramNumber = null;
        if (this.numbers.size() > 1) {
            nonogramNumber = new NonogramNumber();
            for (int i = 1; i < this.numbers.size(); i++) {
                nonogramNumber.add(this.numbers.get(i));
            }
        }
        return nonogramNumber;
    }

    public int first() {
        return this.numbers.get(0);
    }

    public int size() {
        return this.numbers.size();
    }
}
