package org.example;

import java.awt.*;

enum NonogramPointStatus {
    TRUE,
    FALSE,
    BLANK
}

public class NonogramPoint extends Point {

    private boolean isPoint;

    private int score;

    private NonogramPointStatus status;


    public NonogramPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.isPoint = false;
        this.status = NonogramPointStatus.BLANK;
    }

    public int accumulateScore(int score) {
        return this.score += score;
    }

    public void pointing() {
        isPoint = true;
    }

    public boolean isPoint() {
        return isPoint;
    }

    public int getScore() {
        return score;
    }
}
