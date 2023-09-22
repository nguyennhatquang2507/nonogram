package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NonogramMatrix {
    private final int row;
    private final int column;
    private final List<NonogramNumber> verticalNumbers;
    private final List<NonogramNumber> horizontalNumbers;
    private List<NonogramPoint> pointList;
    private int totalPoint;

    public NonogramMatrix(List<NonogramNumber> verticalNumbers, List<NonogramNumber> horizontalNumbers) {
        this.verticalNumbers = verticalNumbers;
        this.horizontalNumbers = horizontalNumbers;
        this.row = horizontalNumbers.size();
        this.column = verticalNumbers.size();
        initPointList();
        initTotalPoint();
        calculatePointList(horizontalNumbers, verticalNumbers.size(), true);
        calculatePointList(verticalNumbers, horizontalNumbers.size(), false);
        this.pointing();
    }

    public List<NonogramPoint> getPointList() {
        return pointList;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    private void initPointList() {
        this.pointList = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columIndex = 0; columIndex < column; columIndex++) {
                pointList.add(new NonogramPoint(columIndex, rowIndex));
            }
        }
    }

    private void initTotalPoint() {
        this.totalPoint = 0;
        this.horizontalNumbers.forEach(number -> this.totalPoint += number.getTotalPoint());
    }

    private void calculatePointList(List<NonogramNumber> numberList, int size, boolean isHorizontal) {
        int y = 0;
        for (NonogramNumber number : numberList) {
            List<Integer> scoreList = NonogramAlgorithms.getScoreList(number, size);
            System.out.println();
            int x = 0;
            for (int score : scoreList) {
                if (score > 0) {
                    Point temp = isHorizontal ? new Point(x, y) : new Point(y, x);
                    NonogramPoint nonogramPoint = pointList.stream()
                            .filter(point -> point.equals(temp))
                            .findFirst().orElse(null);
                    nonogramPoint.accumulateScore(score);
                }
                x++;
            }
            y++;
        }
    }

    public void pointing() {

    }

    @Override
    public String toString() {
        System.out.println("Total Point: " + totalPoint);
        int initRowIndex = pointList.get(0).y;
        for (NonogramPoint point : pointList) {
            if (point.y == initRowIndex) {
                System.out.printf("%4d", point.getScore());
            } else {
                initRowIndex = point.y;
                System.out.printf("\n%4d", point.getScore());
            }
        }
        return "";
    }
}